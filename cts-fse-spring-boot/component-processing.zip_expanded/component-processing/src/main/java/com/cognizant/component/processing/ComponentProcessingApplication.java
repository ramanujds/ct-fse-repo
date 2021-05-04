package com.cognizant.component.processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ComponentProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentProcessingApplication.class, args);
	}

}
