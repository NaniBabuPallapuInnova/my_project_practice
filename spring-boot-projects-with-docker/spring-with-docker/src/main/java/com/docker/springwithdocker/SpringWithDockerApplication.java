package com.docker.springwithdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringWithDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithDockerApplication.class, args);

//		var context = SpringApplication.run(SpringWithDockerApplication.class, args);
//		LazyLoadChecker lazyLoadChecker = context.getBean(LazyLoadChecker.class);
//
//		// Check if bean "controller" exists without initializing it
//		boolean beanExists = context.containsBean("controller");
//		System.out.println("Bean 'controller' exists: " + beanExists);
//
//		// List all bean names
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
////		NotificationService smsService = (NotificationService) context.getBean("controller");
////		smsService.message();
	}

}
