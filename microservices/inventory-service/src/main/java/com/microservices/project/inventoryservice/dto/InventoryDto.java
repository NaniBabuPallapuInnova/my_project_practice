package com.microservices.project.inventoryservice.dto;

import lombok.Builder;

@Builder
public class InventoryDto {

    private Long id;
    private String itemName;

    private Integer quantity;

    private boolean itemInStock;

    public InventoryDto() {
    }

    public InventoryDto(Long id, String itemName, Integer quantity, boolean itemInStock) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemInStock = itemInStock;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isItemInStock() {
        return itemInStock;
    }

    public void setItemInStock(boolean itemInStock) {
        this.itemInStock = itemInStock;
    }

    @Override
    public String toString() {
        return "InventoryDto{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", itemInStock=" + itemInStock +
                '}';
    }
}
