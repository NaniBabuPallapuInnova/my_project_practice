package com.microservices.project.inventoryservice.service;

import com.microservices.project.inventoryservice.dto.InventoryDto;
import com.microservices.project.inventoryservice.mappings.InventoryMapping;
import com.microservices.project.inventoryservice.model.Inventory;
import com.microservices.project.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    public InventoryRepository inventoryRepository;

    @Autowired
    public InventoryMapping inventoryMapping;

    public void saveInventory(InventoryDto inventoryDto){
       Inventory inventory =  inventoryMapping.toEntity(inventoryDto);
        inventoryRepository.save(inventory);
    }
    @Transactional(readOnly = true)
    public boolean isInStock(String itemName) {
        return inventoryRepository.findByItemName(itemName).isPresent(); // check the object is present inside the optional or not.
    }

    /**
     * This method is used to take the all item-names as list type as parameter.
     * it returns the List Of Inventory objects based on  list of item-names.
     */
    @Transactional(readOnly = true)
    public List<InventoryDto> areItemsInStock(List<String> itemNamesList) {
        return inventoryRepository.findByItemNameIn(itemNamesList).stream()
                .map(inventory ->
                                InventoryDto.builder().itemName(inventory.getItemName())
                                .itemInStock(inventory.getQuantity() > 0) // making sure quantity should be greater than 0
                                .build()
                ).collect(Collectors.toList());

    }
}
