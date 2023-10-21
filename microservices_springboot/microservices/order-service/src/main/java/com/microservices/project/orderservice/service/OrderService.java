package com.microservices.project.orderservice.service;

import com.microservices.project.orderservice.dto.OrderDto;
import com.microservices.project.orderservice.dto.OrderLineItemsDto;
import com.microservices.project.orderservice.model.Order;
import com.microservices.project.orderservice.model.OrderLineItems;
import com.microservices.project.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // based on the parameters , it will create constructor automatically during compile time.
@Transactional
public class OrderService {

    public final static String orderNumberStart = "H12345";
    @Autowired
    public OrderRepository orderRepository;

    /**
     *
     * @param orderDto getting the orderDto object and convert the orderDto object into Order object and save it.
     *
     */
    public void saveOrder(OrderDto orderDto){
        Order order = new Order();
        order.setOrderNumber("H123"+String.format("%03d", new Random().nextInt(1000)));

       List<OrderLineItems> orderLineItemsList =  orderDto.getOrderLineItemsList().stream()
//               .map(orderLineItemsDto -> mapTo(orderLineItemsDto)) // .map(this::mapTo) both are same.
               .map(this::mapTo)
               .collect(Collectors.toList());

       order.setOrderLineItemsList(orderLineItemsList);
       orderRepository.save(order);
    }

    /**
     * This method is used to convert Dto into Entity.
     * @param orderLineItemsDto Getting the OrderLineItemsDto object and convert into OrderLineItems.
     * @return converted Entity.
     */
    private OrderLineItems mapTo(OrderLineItems orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setitemName(orderLineItemsDto.getitemName());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return  orderLineItems;
    }
}
