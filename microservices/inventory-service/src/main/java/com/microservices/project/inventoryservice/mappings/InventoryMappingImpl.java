package com.microservices.project.inventoryservice.mappings;


import com.microservices.project.inventoryservice.dto.InventoryDto;
import com.microservices.project.inventoryservice.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryMappingImpl implements InventoryMapping {

    /**
     * This method is used to convert the Single Product Entity into Single ProductDto.
     */
    @Override
    public InventoryDto toDto(Inventory inventory) {
        if (inventory == null) {
            return null;
        }

        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(inventory.getId());
        inventoryDto.setItemName(inventory.getItemName());
        inventoryDto.setQuantity(inventory.getQuantity());
        return inventoryDto;
    }


    /**
     *  method is used to convert Single ProductDto into the Single Product Entity.
     */

    @Override
    public Inventory toEntity(InventoryDto inventoryDto) {
        if (inventoryDto == null) {
            return null;
        }


        Inventory inventory = new Inventory();
        inventory.setId(inventoryDto.getId());
        inventory.setItemName(inventoryDto.getItemName());
        inventory.setQuantity(inventoryDto.getQuantity());
        return inventory;
    }

    /**
     *  This method is used to convert the List Of Product Entities into List Of ProductDtos.
     */
    @Override
    public List<InventoryDto> toDtoList(List<Inventory> inventoryList) {
        if (inventoryList == null) {
            return null;
        }

        List<InventoryDto> inventoryDtoList = new ArrayList<>(inventoryList.size());
        for (Inventory inventory : inventoryList) {
            inventoryDtoList.add(toDto(inventory));
        }
        return inventoryDtoList;
    }

    /**
     *  This method is used to convert List Of ProductDtos into the List Of Product Entities.
     */
    @Override
    public List<Inventory> toEntityList(List<InventoryDto> inventoryDtoList) {
        if (inventoryDtoList == null) {
            return null;
        }

        List<Inventory> inventoryList = new ArrayList<>(inventoryDtoList.size());
        for (InventoryDto inventoryDto : inventoryDtoList) {
            inventoryList.add(toEntity(inventoryDto));
        }

        return inventoryList;

    }
}
