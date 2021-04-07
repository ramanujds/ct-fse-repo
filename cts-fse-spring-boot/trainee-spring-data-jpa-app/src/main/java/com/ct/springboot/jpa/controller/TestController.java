package com.ct.springboot.jpa.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.springboot.jpa.model.Trainee;

@RestController
@RequestMapping("/api")
public class TestController {

	@GetMapping("/hello")
	public String sayHello() {
		System.err.println("Hello World");
		return "Hello World";
	}
	
//	@GetMapping("/dummy-trainee")
//	public Trainee getTrainee() {
//		return new Trainee(10211L, "Tushar", "tushar@gmail.com", LocalDate.of(2000, 10, 25));
//	}
//	
//	@GetMapping("/testing")
//	public Trainee testTrainee() {
//		return new Trainee(10001, "Rahul", "rahul@yahoo.com", LocalDate.of(1995, 02, 10));
//	}
//	
}
