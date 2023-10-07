package com.example.Practice_App.mappings;

import com.example.Practice_App.domain.Product;
import com.example.Practice_App.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDTO);
}
