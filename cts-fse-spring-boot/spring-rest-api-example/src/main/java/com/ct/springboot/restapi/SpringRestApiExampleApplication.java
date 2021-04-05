package com.ct.springboot.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

@SpringBootApplication
public class SpringRestApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiExampleApplication.class, args);
	}
	
	

}
