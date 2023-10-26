package com.microservices.project.productservice.controller;

import com.microservices.project.productservice.dto.ProductDto;
import com.microservices.project.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * This method is used to get All Products and @return response with fetchedProductDtoList and status message.
     */
    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> productDtoList = productService.getProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public HttpStatus createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
        return HttpStatus.CREATED;
    }


}
