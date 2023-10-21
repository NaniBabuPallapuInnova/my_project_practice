package com.microservices.project.productservice;

import com.microservices.project.productservice.dto.ProductDto;
import com.microservices.project.productservice.repository.ProductRepository;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
/*import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;*/
import org.springframework.test.web.servlet.MockMvc;
/*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
*/

@SpringBootTest
//@Testcontainers // JUnit 5 understands that we are going to use TestContainer to run this particular tests.
//@AutoConfigureMockMvc
class ProductServiceApplicationTests {

/*
    //    @Container
//    private static final MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0.19");
*/
/*    @Container
    private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0.19")
            .withDatabaseName("product_service")
            .withUsername("root")
            .withPassword("root");*//*

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; //convert to json to pojo and pojo to json

    @Autowired
    private ProductRepository productRepository;
*/

    @Test
    void contextLoads() {
    }
/*
    @Test
    void shouldCreateProduct() throws Exception {
        ProductDto productDto = getProductDto();
        String productDtoString = objectMapper.writeValueAsString(productDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productDtoString))
                .andExpect(status().isCreated());
        Assertions.assertEquals(1, productRepository.findAll().size());
    }

    private ProductDto getProductDto() {

        return ProductDto.builder()
                .name("Samsung AC")
                .description("Samsung AC 5 star")
                .price(BigDecimal.valueOf(35000.30))
                .build();
    }*/

}
