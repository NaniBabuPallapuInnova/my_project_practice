package com.example.shopping.controller;

import com.example.shopping.domain.Product;
import com.example.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;



    @PostMapping("/add-Product")
    public @ResponseBody String saveProductType1(@RequestParam(name = "name", defaultValue = "Soap")String name, @RequestParam(name = "price") double price, @RequestParam String expiryDate){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setExpiryDate(expiryDate);
        productService.saveProduct(product);
        return "SAVED";
    }

    @PostMapping("/add-Product-type2")
    public HttpStatus saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return HttpStatus.ACCEPTED;
    }

    @PostMapping("/save-all-Products")
    public List<Product> saveAllProducts(@RequestBody List<Product> productList){
        List<Product> products = productService.saveAllProducts(productList);
        return products;
    }

    @GetMapping("/display-products")
    public List<Product> displayAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/product-by-id/{id}")
    public Product displayProductById(@PathVariable("id")Long id){
        return productService.findProductById(id);
    }

    @PostMapping("/update-product/{id}")
    public Product updateProductById(@PathVariable Long id){
        Product product = productService.findProductById(id);
        product.setName("Mobile");
        product.setPrice(15000.0);
        product.setExpiryDate("12-11-2026");
        productService.saveProduct(product);
        return product;
    }

    @PostMapping("/update-product-body/{id}")
    public Product updateProductByProductId(@RequestBody Product product, @PathVariable("id") Long id){
        Product productObject = productService.findProductById(id);

        /*

        product1.setName(product.getName());
        product1.setSalary(product.getSalary());
        product1.setCompanyName(product.getCompanyName());
        productService.saveProduct(product1);

        */

        product.setId(productObject.getId());
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @DeleteMapping("/delete-all-products")
    public void deleteAllProducts(){
        productService.deleteAllProducts();
    }

}
