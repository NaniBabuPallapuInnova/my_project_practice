package com.microservices.project.inventoryservice.controller;

import com.microservices.project.inventoryservice.dto.InventoryDto;
import com.microservices.project.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/stock/{item-name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean isInStock(@PathVariable(name = "item-name") String itemName) {
        return inventoryService.isInStock(itemName);
    }
    @GetMapping("/items-list-stock")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<InventoryDto> areItemsInStock(@RequestParam(name = "itemName") List<String> itemNameList) {
        return inventoryService.areItemsInStock(itemNameList);
    }
}
