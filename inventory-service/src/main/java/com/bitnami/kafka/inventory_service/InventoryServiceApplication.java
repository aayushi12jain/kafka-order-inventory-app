package com.bitnami.kafka.inventory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bitnami.kafka.inventory_service.model.Inventory;
import com.bitnami.kafka.inventory_service.repository.InventoryRepository;


@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			inventoryRepository.save(new Inventory("test123", 100));
			inventoryRepository.save(new Inventory("apple-456", 50));
		};
	}

	@Bean
	public ObjectMapper objectMapper() {
    	return new ObjectMapper();
	}


}
