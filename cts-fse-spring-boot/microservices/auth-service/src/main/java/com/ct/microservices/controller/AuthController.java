package com.ct.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.microservices.model.AuthToken;
import com.ct.microservices.model.Credentials;
import com.ct.microservices.service.AuthUserDetailsService;
import com.ct.microservices.util.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/public")
public class AuthController {
	
	@Autowired
	private JwtTokenUtil tokenUtil;
	
	@Autowired
	private AuthUserDetailsService userDetailsService; 
	
	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/authenticate")
	public AuthToken authenticate(@RequestBody Credentials creds) {
		
		log.info(creds.toString());
		
		authManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getUsername(),creds.getPassword())
				);
		
		UserDetails userDetails=userDetailsService.loadUserByUsername(creds.getUsername());
		
		String jwt=tokenUtil.generateToken(userDetails);
		return new AuthToken(jwt);
		
	}
	
	
	
	
	
}
