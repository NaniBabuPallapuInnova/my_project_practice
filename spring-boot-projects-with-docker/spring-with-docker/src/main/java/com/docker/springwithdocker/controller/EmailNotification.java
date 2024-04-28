package com.docker.springwithdocker.controller;


public class EmailNotification implements Notification {


    @Override
    public void message() {
        System.out.println("SENDING AN EMAIL NOTIFICATION");
    }
}
