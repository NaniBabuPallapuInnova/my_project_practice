package com.docker.springwithdocker.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class NotificationController {

    @Autowired
    public NotificationService notificationService;

    @GetMapping("/message")
    public String getMessage(){
       notificationService.message();
       return "Completed";
    }


}
