package com.microservices.project.productservice.service;

import com.microservices.project.productservice.dto.ProductDto;
import com.microservices.project.productservice.mappings.ProductMapping;
import com.microservices.project.productservice.model.Product;
import com.microservices.project.productservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapping productMapping;

    /**
     * this method is used to fetch all the products from Product table  as convert them into ProductDtos
     * @return finally this method returns List of ProductDtos
     */
    public List<ProductDto> getProducts(){
        log.info("fetching all products");
        List<Product> products =  productRepository.findAll();
        log.info("fetched all products");
        return productMapping.toDtoList(products);
    }

    /**
     * @param productDto This method is used to take Single ProductDto as Parameters and convert them into Single Product Entity.
     * Save the Single Product Entity in Database.
     */
    public void createProduct(ProductDto productDto){
        Product product = productMapping.toEntity(productDto);
        productRepository.save(product);
        log.info("product is saved. Product Id : {} ", product.getId());
    }


}
