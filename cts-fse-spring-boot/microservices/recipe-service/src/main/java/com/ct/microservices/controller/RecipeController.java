package com.ct.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.microservices.model.Recipe;
import com.ct.microservices.model.RecipeMenu;
import com.ct.microservices.service.RecipeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/recipes")
@Slf4j
public class RecipeController {

	@Autowired
	RecipeService service;
	
	
	@GetMapping(value = "/item/{itemName}", produces = "application/json")
	@HystrixCommand(fallbackMethod = "getRecipeFallback",
			commandProperties = {
					@HystrixProperty(name ="execution.timeout.enabled", value = "true" ),
					@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="5000")
									
			}
	
			)
	public RecipeMenu getRecipe(@PathVariable String itemName) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service.getRecipe(itemName);
	}
	
	public RecipeMenu getRecipeFallback(@PathVariable String itemName) {
		log.error("Recipe Service responded from Fallback");
		return null;
	}
	
}
