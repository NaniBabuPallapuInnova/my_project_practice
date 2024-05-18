package com.docker.springwithdocker.async_example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    public void createOrder() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("ORDER HAS BEEN CREATED");
    }

    public void submitOrder(Order order) throws InterruptedException {
        Thread.sleep(2000);
        order.setProductCount(10); // Modify order data

        System.out.println("ORDER SUBMITTED");
    }

    @Async("asyncTaskExecutor")
    public Order notifyToUserOrderDetails(Order order) throws InterruptedException {
        // Execute notifyToUserOrderDetails asynchronously
        System.out.println("NOTIFYING THE USER ORDER DETAILS");

        return order;
    }
    @Async("asyncTaskExecutor")

    public void approveTheOrder() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("ORDER HAS BEEN APPROVED");
    }
    @Async("asyncTaskExecutor")

    public void packTheOrder() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("PACKED THE ORDER");
    }
    @Async("asyncTaskExecutor")

    public void deliveryOrder() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("ORDER IS DELIVERED");
    }
}
