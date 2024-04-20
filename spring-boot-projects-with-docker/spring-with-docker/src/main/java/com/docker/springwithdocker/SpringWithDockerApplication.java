package com.docker.springwithdocker;

import com.docker.springwithdocker.controller.NotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWithDockerApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(SpringWithDockerApplication.class, args);



		NotificationService smsService = (NotificationService) context.getBean("controller");
		smsService.message();
	}

}
