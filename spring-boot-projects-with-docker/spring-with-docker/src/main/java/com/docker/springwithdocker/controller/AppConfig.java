package com.docker.springwithdocker.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="email")
    public EmailNotification emailNotification(){
        return new EmailNotification();
    }

    @Bean(name="sms")
    public SMSNotification smsNotification(){
        return new SMSNotification();
    }

    @Bean(name="controller")
    public NotificationService notificationController(){
        return  new NotificationService(smsNotification());
    }
}
