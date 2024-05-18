package com.docker.springwithdocker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


public class NotificationService {



    public Notification notification;

    public NotificationService(@Autowired Notification notification) {
        this.notification = notification;
    }


    public void message(){

        notification.message();
        System.out.println("SENDING NOTIFICATION IS COMPLETED");
    }
}
