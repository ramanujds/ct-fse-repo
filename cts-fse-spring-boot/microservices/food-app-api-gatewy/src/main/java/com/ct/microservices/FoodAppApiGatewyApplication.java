package com.ct.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootApplication
//@EnableEurekaClient
//@EnableZuulProxy
public class FoodAppApiGatewyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApiGatewyApplication.class, args);
	}
	
	

}
