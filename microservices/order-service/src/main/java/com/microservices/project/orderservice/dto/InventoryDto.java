package com.microservices.project.orderservice.dto;

import lombok.Builder;

@Builder
public class InventoryDto {
    private String itemName;
    private boolean itemInStock;

    public InventoryDto() {
    }

    public InventoryDto(String itemName, boolean itemInStock) {
        this.itemName = itemName;
        this.itemInStock = itemInStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
                "itemName='" + itemName + '\'' +
                ", itemInStock=" + itemInStock +
                '}';
    }
}
