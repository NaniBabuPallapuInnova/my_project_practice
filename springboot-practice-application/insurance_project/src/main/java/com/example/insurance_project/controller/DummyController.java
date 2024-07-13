package com.example.insurance_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController{


    @GetMapping("/dummyMessage")
    public String showDummyMessage(){
        System.out.println("====== WELCOME TO MY INSURANCE PROJECT ===========");
        return "WELCOME TO MY INSURANCE PROJECT";
    }
}
