package com.ct.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.microservices.model.CartDetails;
import com.ct.microservices.service.CartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {
	
	@Autowired
	CartService service;

	@GetMapping("/item/{menuItemId}/coupon/{couponCode}")

	public CartDetails getCartDetails(@PathVariable long menuItemId, @PathVariable String couponCode) {
		return service.getCartDetails(menuItemId, couponCode);
	}
	
	
	
}
