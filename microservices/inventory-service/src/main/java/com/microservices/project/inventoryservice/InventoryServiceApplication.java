package com.microservices.project.inventoryservice;

import com.microservices.project.inventoryservice.model.Inventory;
import com.microservices.project.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	/**
	 * at the time of application this bean will be created and part of this object we are going to create below two objects with data.
	 *
	 */
/*	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setItemName("Iphone 13");
			inventory.setQuantity(50);

			Inventory inventory1 = new Inventory();
			inventory1.setItemName("Iphone 14");
			inventory1.setQuantity(60);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}*/

}
