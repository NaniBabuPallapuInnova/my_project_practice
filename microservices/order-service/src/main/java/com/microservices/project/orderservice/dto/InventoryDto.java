package com.microservices.project.orderservice.dto;

import lombok.Builder;

@Builder
public class InventoryDto {
    private String itemName;
    private boolean isInStock;

    public InventoryDto() {
    }

    public InventoryDto(String itemName, boolean isInStock) {
        this.itemName = itemName;
        this.isInStock = isInStock;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    @Override
    public String toString() {
        return "InventoryDto{" +
                "itemName='" + itemName + '\'' +
                ", isInStock=" + isInStock +
                '}';
    }
}
