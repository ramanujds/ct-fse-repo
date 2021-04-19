package com.ct.springboot.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.springboot.example.model.Message;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Message greetHello() {
		return new Message("Hello", "Important", "Your product has been delivered");
	}
	
}
