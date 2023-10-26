package com.microservices.project.inventoryservice.mappings;

import com.microservices.project.inventoryservice.dto.InventoryDto;
import com.microservices.project.inventoryservice.model.Inventory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryMapping {

    // This method is used to convert the Single Product Entity into Single ProductDto.
    InventoryDto toDto(Inventory inventory);

    // This method is used to convert Single ProductDto into the Single Product Entity.
    Inventory toEntity(InventoryDto inventoryDto);

    // This method is used to convert the List Of Product Entities into List Of ProductDtos.
    List<InventoryDto> toDtoList(List<Inventory> productList);

    // This method is used to convert List Of ProductDtos into the List Of Product Entities.
    List<Inventory> toEntityList(List<InventoryDto> productDtoList);
}
