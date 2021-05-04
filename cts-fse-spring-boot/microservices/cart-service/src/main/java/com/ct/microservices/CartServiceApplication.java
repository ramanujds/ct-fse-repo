package com.ct.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ct.microservices.controller.AuthInterceptor;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
@EnableFeignClients(basePackages ="com.ct.microservices.util" )
public class CartServiceApplication extends WebMvcConfigurerAdapter{
	@Autowired
	AuthInterceptor interceptor;
	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplateBean() {
		return new RestTemplate();
	}
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(interceptor);
	}
	
}
