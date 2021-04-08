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
import com.ct.microservices.repository.MenuItemRepo;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {

	@Autowired
	MenuItemRepo repo;
	@Autowired
	Environment env;
	
	@GetMapping("/items/{menuItemId}")
	public MenuItem getMenuItem(@PathVariable long menuItemId) {
		MenuItem item= repo.findByMenuItemId(menuItemId);
		int port=Integer.parseInt(env.getProperty("local.server.port"));
		item.setPort(port);
		return item;
	}
	
	@PostMapping("/items")
	public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
		return repo.save(menuItem);
	}
	
}
