package com.docker.springwithdocker.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Bean(name="email")
    public EmailNotification emailNotification(){
        return new EmailNotification();
    }

    @Bean(name="emails")
    public Notification emailNotifications(){
        return new SMSNotification();
    }

    @Bean(name="sms")
    public SMSNotification smsNotification(){
        return new SMSNotification();
    }

    @Bean(name="controller")
    @Lazy
    public NotificationService notificationController(){
        return new NotificationService(emailNotifications());
    }
}
