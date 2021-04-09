package com.ct.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.microservices.model.MenuItem;
import com.ct.microservices.model.RecipeMenu;
import com.ct.microservices.repository.MenuItemRepo;
import com.ct.microservices.service.MenuItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/menu-item")
@Slf4j
public class MenuItemController {

	@Autowired
	MenuItemRepo repo;
	@Autowired
	Environment env;
	
	@Autowired
	MenuItemService service;
	
	
	
	@GetMapping("/items/{menuItemId}")
	@HystrixCommand(fallbackMethod = "getMenuItemFallback",
	commandProperties = {
			@HystrixProperty(name ="execution.timeout.enabled", value = "true" ),
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="5000")
							
	})
	public MenuItem getMenuItem(@PathVariable long menuItemId) {
		MenuItem item= service.getMenuItem(menuItemId);
		
		return item;
	}
	
	
	public MenuItem getMenuItemFallback(@PathVariable long menuItemId) {
		log.error("menu-item-service responded fallback");
		return null;
	}
	
	@PostMapping("/items")
	public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
		return repo.save(menuItem);
	}
	
}
