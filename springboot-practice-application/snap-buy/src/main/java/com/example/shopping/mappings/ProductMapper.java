package com.example.shopping.mappings;

import com.example.shopping.domain.Product;
import com.example.shopping.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDTO);
}
