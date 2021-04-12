package com.ct.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class ApiController {

//	@GetMapping("/public/hello")
//	public String sayHello(){
//		return "Hello World";
//	}
	
	@GetMapping("/admin/hello")
	public String sayHelloAdmin(){
		return "Hello Admin";
	}
	
	@GetMapping("/user/hello")
	public String sayHelloUser(){
		return "Hello Sir...";
	}
}
