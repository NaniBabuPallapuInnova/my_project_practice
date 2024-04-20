package com.docker.springwithdocker.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class SMSNotification implements Notification{
    @Override
    public void message() {
        System.out.println("SENDING AN SMS NOTIFICATION");
    }
}
