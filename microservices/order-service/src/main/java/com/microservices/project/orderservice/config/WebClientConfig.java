package com.microservices.project.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *  we are going to maintain configuration about the webclient class.
 *  that's why we created WebClientConfig class using @Configuration.
 */
@Configuration
public class WebClientConfig {

    /**
     * This Method will be creating a Bean as type WebClient.
     *
     * If we want to use this particular webclient bean inside the "OrderService", we have to define this webclient name with same.
     */
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
