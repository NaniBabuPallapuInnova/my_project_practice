package com.microservices.project.orderservice.dto;

import com.microservices.project.orderservice.model.Order;

import java.math.BigDecimal;

public class OrderLineItemsDto {
    private Long id;

    private String itemName;

    private BigDecimal price;

    private Integer quantity;

    private OrderDto orderDto;

    public OrderLineItemsDto() {
    }

    public OrderLineItemsDto(Long id, String itemName, BigDecimal price, Integer quantity, OrderDto orderDto) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.orderDto = orderDto;
    }

    public OrderLineItemsDto(String itemName, BigDecimal price, Integer quantity, OrderDto orderDto) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.orderDto = orderDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    @Override
    public String toString() {
        return "OrderLineItemsDto{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
