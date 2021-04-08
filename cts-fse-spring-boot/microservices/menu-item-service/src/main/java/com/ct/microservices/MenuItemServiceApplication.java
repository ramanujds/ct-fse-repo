package com.ct.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MenuItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuItemServiceApplication.class, args);
	}

}
