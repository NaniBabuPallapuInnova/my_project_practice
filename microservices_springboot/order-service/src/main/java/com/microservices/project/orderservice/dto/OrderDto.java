package com.microservices.project.orderservice.dto;

import com.microservices.project.orderservice.model.OrderLineItems;

import java.util.List;

public class OrderDto {
    private List<OrderLineItems> orderLineItemsList;

    public OrderDto() {
    }

    public OrderDto( List<OrderLineItems> orderLineItemsList) {
        this.orderLineItemsList = orderLineItemsList;
    }
    public List<OrderLineItems> getOrderLineItemsList() {
        return orderLineItemsList;
    }

    public void setOrderLineItemsList(List<OrderLineItems> orderLineItemsList) {
        this.orderLineItemsList = orderLineItemsList;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                ", orderLineItemsList=" + orderLineItemsList +
                '}';
    }
}
