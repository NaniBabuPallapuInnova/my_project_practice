package com.example.Practice_App.service;

import com.example.Practice_App.domain.Product;
import com.example.Practice_App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).get();
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> findAllProductsById(List<Long> id){
        return productRepository.findAllById(id);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
    public void deleteAllProducts(){
        productRepository.deleteAll();
    }


}
