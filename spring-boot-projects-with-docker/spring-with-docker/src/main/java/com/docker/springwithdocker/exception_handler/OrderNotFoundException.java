package com.docker.springwithdocker.exception_handler;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException(){
        super("Order Not Found");
    }
}
