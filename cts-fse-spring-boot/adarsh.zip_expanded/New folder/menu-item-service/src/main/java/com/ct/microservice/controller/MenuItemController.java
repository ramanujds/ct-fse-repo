package com.ct.microservice.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.microservice.model.MenuItem;
//import com.ct.microservice.model.RecipeMenu;
import com.ct.microservice.repository.MenuItemRepo;
import com.ct.microservice.service.MenuItemService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {

	@Autowired
	MenuItemRepo repo;
	@Autowired
	Environment env;
	
	@Autowired
	MenuItemService service;
	
	@PostConstruct
	public void init()
	{
		addMenuItem(new MenuItem(1,1001,"Sandwich",50.0,0));
		addMenuItem(new MenuItem(2,1002,"Burger",100.0,0));
		addMenuItem(new MenuItem(3,1003,"Pizza",150.0,0));
		addMenuItem(new MenuItem(4,1004,"Choclate",20.0,0));
	}
	
	@GetMapping("/items/{menuItemId}")
	public MenuItem getMenuItem(@PathVariable long menuItemId) {
		MenuItem item= service.getMenuItem(menuItemId);
		
		return item;
	}
	
	
//	public MenuItem getMenuItemFallback(@PathVariable long menuItemId) {
//		log.error("menu-item-service responded fallback");
//		return null;
//	}
	
	@PostMapping("/items")
	public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
		return repo.save(menuItem);
	}
	
}