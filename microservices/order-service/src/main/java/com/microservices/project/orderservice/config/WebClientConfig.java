package com.microservices.project.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
     *
     *
     * @LoadBalanced:  It will add the client side load-balancing capabilities to the webclient builder. whenever you are creating the instance of webclient using this webclient builder,
     * it will automatically create the client side load-balancing, and we use this client side load-balancing to the call the inventory-services.
     * Even though if our order-service finds multiple instances of inventory-service , it won't be confused, and it will call instances of inventory-service one instance after another instance.
     * note : simply resolve this exception : Failed to resolve 'inventory-service' after 2 queries
     *
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
