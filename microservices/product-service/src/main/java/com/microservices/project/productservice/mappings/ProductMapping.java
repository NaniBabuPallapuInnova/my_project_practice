package com.microservices.project.productservice.mappings;

import com.microservices.project.productservice.dto.ProductDto;
import com.microservices.project.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapping {

    // This method is used to convert the Single Product Entity into Single ProductDto.
    ProductDto toDto(Product product);

    // This method is used to convert Single ProductDto into the Single Product Entity.
    Product toEntity(ProductDto productDto);

    // This method is used to convert the List Of Product Entities into List Of ProductDtos.
    List<ProductDto> toDtoList(List<Product> productList);

    // This method is used to convert List Of ProductDtos into the List Of Product Entities.
    List<Product> toEntityList(List<ProductDto> productDtoList);
}
