package com.example.Practice_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PracticeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeAppApplication.class, args);
	}

}
