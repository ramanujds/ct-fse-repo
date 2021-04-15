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
	@HystrixCommand(fallbackMethod = "getCartDetailsFallback",
			commandProperties = {
					@HystrixProperty(name ="execution.timeout.enabled", value = "true" ),
					@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="5000")
									
			})
	public CartDetails getCartDetails(@PathVariable long menuItemId, @PathVariable String couponCode) {
		return service.getCartDetails(menuItemId, couponCode);
	}
	
	public CartDetails getCartDetailsFallback(@PathVariable long menuItemId, @PathVariable String couponCode) {
		log.error("cart-service responded fallback");
		return new CartDetails(menuItemId, "Chocolate", 150, couponCode, 10, 50, 135, 0, 0, null);
	}
	
}