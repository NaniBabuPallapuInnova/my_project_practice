package com.microservices.project.orderservice.dto;


import java.util.List;

public class OrderDto {
    private List<OrderLineItemsDto> orderLineItemsListDto;

    public OrderDto() {
    }

    public OrderDto(List<OrderLineItemsDto> orderLineItemsListDto) {
        this.orderLineItemsListDto = orderLineItemsListDto;
    }

    public List<OrderLineItemsDto> getOrderLineItemsListDto() {
        return orderLineItemsListDto;
    }

    public void setOrderLineItemsListDto(List<OrderLineItemsDto> orderLineItemsListDto) {
        this.orderLineItemsListDto = orderLineItemsListDto;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderLineItemsListDto=" + orderLineItemsListDto +
                '}';
    }
}
