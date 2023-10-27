package com.microservices.project.orderservice.service;

import com.microservices.project.orderservice.dto.InventoryDto;
import com.microservices.project.orderservice.dto.OrderDto;
import com.microservices.project.orderservice.dto.OrderLineItemsDto;
import com.microservices.project.orderservice.model.Order;
import com.microservices.project.orderservice.model.OrderLineItems;
import com.microservices.project.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // based on the parameters , it will create constructor automatically during compile time.
@Transactional
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    public static final String ORDER_NUMBER_START = "H123";



    @Autowired
    public OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;

    /**
     * getting the orderDto object and convert the orderDto object into Order object and save it.
     * This method is used to placeOrder an order When the item is in stock.
     * We are making sure if item is in stock or not, by making synchronous request from OrderService to InventoryService.
     * If item is in stock, we are return response from InventoryService as boolean true and place the order by using save(order) method, Otherwise throwing IllegalArgumentException.
     */
    public void placeOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNumber(ORDER_NUMBER_START + String.format("%03d", new Random().nextInt(1000)));

        List<OrderLineItems> orderLineItemsList = orderDto.getOrderLineItemsListDto().stream()
//               .map(orderLineItemsDto -> mapTo(orderLineItemsDto)) // .map(this::mapTo) both are same.
                .map(this::mapToDto)
                .collect(Collectors.toList());

        for (OrderLineItems orderLineItems : orderLineItemsList) {
            orderLineItems.setOrder(order);
        }

        order.setOrderLineItemsList(orderLineItemsList);

        // fetching itemNames from getOrderLineItemsList() and store them in listOfItemNames
        List<String> listOfItemNames = order.getOrderLineItemsList().stream().map(OrderLineItems::getItemName).collect(Collectors.toList());
        //call inventory-service and placeOrder if items are in stock.
        // we are adding inventory-service stock url with port number and GetRequestUrl from InventoryController.
        //uriBuilder ,it will create queryParam like "http://localhost:8087/api/inventory/items-list-stock?itemName=Iphone13&&itemName=Iphone14&&itemName=Iphone15" etc. like this.

//        InventoryDto[] inventoryDtoArray = webClient.get().uri("http://localhost:8087/api/inventory/items-list-stock", uriBuilder -> uriBuilder.queryParam("itemName", listOfItemNames).build())
//                .retrieve()
//                .bodyToMono(InventoryDto[].class) // This is from inventory-service response class(areItemsInStock() it returns InventoryDto Array as response)
//                .block(); // to make synchronous request.

        //inventory-service - it's application we have provided in application.properties in inventory-service - localhost:8087 instead of hardcoded value
        InventoryDto[] inventoryDtoArray = webClientBuilder.build().get().uri("http://inventory-service/api/inventory/items-list-stock", uriBuilder -> uriBuilder.queryParam("itemName", listOfItemNames).build())
                .retrieve()
                .bodyToMono(InventoryDto[].class) // This is from inventory-service response class(areItemsInStock() it returns InventoryDto Array as response)
                .block(); // to make synchronous request.

        boolean allItemsAreInStock = Arrays.stream(inventoryDtoArray).allMatch(InventoryDto::isItemInStock); // it will create a stream, so that we can easily call the allMatch method and store the response as boolean in local variable as allItemsAreInStock.
        if (allItemsAreInStock) {
            orderRepository.save(order);
            log.info("order has been saved successfully order {}:", order);
        } else {
            throw new IllegalArgumentException("product is not in stock. please try again once product is available.");
        }
    }

    /**
     * This method is used to convert Dto into Entity.
     *
     * @param orderLineItemsDto Getting the OrderLineItemsDto object and convert into OrderLineItems.
     * @return converted Entity.
     */
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setItemName(orderLineItemsDto.getItemName());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
