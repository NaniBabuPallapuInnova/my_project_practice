package com.microservices.project.inventoryservice.service;

import com.microservices.project.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {
    @Autowired
    public InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String itemName) {
        return inventoryRepository.findByItemName(itemName).isPresent(); // check the object is present inside the optional or not.
    }
}
