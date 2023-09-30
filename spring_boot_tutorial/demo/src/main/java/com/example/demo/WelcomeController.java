package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    String data = "Welcome To My Plant %s!";
    @GetMapping("/")
    public String message(@RequestParam(value = "name", defaultValue = "Nani") String name){
        return String.format(data,name);
    }

    @GetMapping("/show")
    public Student display(@RequestParam(value = "name", defaultValue = "Nani") String name){
       return new Student(1,name);
    }
}
