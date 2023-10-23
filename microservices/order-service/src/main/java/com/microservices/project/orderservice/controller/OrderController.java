package com.microservices.project.orderservice.controller;

import com.microservices.project.orderservice.dto.OrderDto;
import com.microservices.project.orderservice.model.Order;
import com.microservices.project.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor // based on the parameters , it will create constructor automatically during compile time.
public class OrderController {


    @Autowired
    public OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto orderDto){
        orderService.placeOrder(orderDto);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }


}
