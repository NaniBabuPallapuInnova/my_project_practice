package com.microservices.project.productservice.mappings.mappingImpl;

import com.microservices.project.productservice.dto.ProductDto;
import com.microservices.project.productservice.mappings.ProductMapping;
import com.microservices.project.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMappingImpl implements ProductMapping {

    @Override
    public ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }


        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> productList) {
        if (productList == null) {
            return null;
        }

        List<ProductDto> productDtoList = new ArrayList<>(productList.size());
        for (Product product : productList) {
            productDtoList.add(toDto(product));
        }
        return productDtoList;
    }

    @Override
    public List<Product> toEntityList(List<ProductDto> productDtoList) {
        if (productDtoList == null) {
            return null;
        }

        List<Product> productList = new ArrayList<>(productDtoList.size());
        for (ProductDto productDto : productDtoList) {
            productList.add(toEntity(productDto));
        }

        return productList;

    }
}
