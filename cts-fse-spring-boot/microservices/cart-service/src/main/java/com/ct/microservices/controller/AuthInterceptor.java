package com.ct.microservices.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	RestTemplate rt;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Request Intercepted...");
		boolean isAuthorized=true;
		String uri=request.getRequestURI();
		if(uri.contains("public/authenticate")) {
			return true;
		}
		System.out.println(uri);
		String token=request.getHeader("Authorization");
		if(token==null) {
			token="fake-jwt-token";
		}
		
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", token);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			try {
			ResponseEntity responseEntity = rt.exchange("http://localhost:8000"+uri, HttpMethod.GET, entity, Object.class);
			 if(responseEntity.getStatusCode().isError()) {
				 isAuthorized=false;
				 throw new ResponseStatusException(responseEntity.getStatusCode());
			 }
			}
			catch (HttpClientErrorException e) {
				throw new ResponseStatusException(e.getStatusCode(),e.getMessage());
			}
		
		return isAuthorized;
	}
	
}