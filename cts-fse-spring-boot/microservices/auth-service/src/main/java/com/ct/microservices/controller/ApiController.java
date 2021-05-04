package com.ct.microservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/cart/**")
	public ResponseEntity<Object> allGets(){
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/cart/**")
	public ResponseEntity<Object> allPosts(){
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
}
