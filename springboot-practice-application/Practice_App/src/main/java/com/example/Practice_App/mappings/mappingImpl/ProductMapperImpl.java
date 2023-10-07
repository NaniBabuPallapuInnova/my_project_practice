package com.example.Practice_App.mappings.mappingImpl;

import com.example.Practice_App.domain.Product;
import com.example.Practice_App.dto.ProductDTO;
import com.example.Practice_App.mappings.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductDTO toDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
