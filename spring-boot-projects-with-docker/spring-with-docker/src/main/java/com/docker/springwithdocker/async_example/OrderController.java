package com.docker.springwithdocker.async_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/welcome")
    public String someDetails() {
        return "Welcome To My World";
    }

    @PostMapping("/process")
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {

        orderService.createOrder();
        orderService.submitOrder(order);
        orderService.notifyToUserOrderDetails(order);
        orderService.approveTheOrder();
        orderService.packTheOrder();
        orderService.deliveryOrder();

        // Return response to the user immediately after modifying the order data
        return ResponseEntity.ok(order);
    }
}
