package com.docker.springwithdocker.async_example;

import com.docker.springwithdocker.exception_handler.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
public class OrderController {

    OrderService orderService1 = new OrderService();
    @Autowired
    OrderService orderService;

    @GetMapping("/welcome")
    public String someDetails() {
        return "Welcome To My World";
    }

    @PostMapping("/process")
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException, OrderNotFoundException {

        orderService.createOrder();
        orderService.submitOrder(order);
        orderService.notifyToUserOrderDetails(order);
        orderService.approveTheOrder();
        orderService.packTheOrder();
        orderService.deliveryOrder();

        boolean value = true;
        if (value) {
            throw new NullPointerException();
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
