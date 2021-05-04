package com.ct.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ct.microservices.model.AuthToken;
import com.ct.microservices.model.Credentials;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/public")
public class AuthController {
	@Autowired
	RestTemplate rt;

	@PostMapping("/authenticate")
	public AuthToken authenticate(@RequestBody Credentials creds) {
		
		
		
		AuthToken token=rt.postForObject("http://localhost:8000/public/authenticate",creds, AuthToken.class);
		
		return token;
		
	}
	
	
	
	
	
}
