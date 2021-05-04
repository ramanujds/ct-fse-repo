package com.ct.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.ct.microservices.model.MenuItem;

import com.ct.microservices.repository.MenuItemRepo;

@Service
public class MenuItemService {

	
	@Autowired
	MenuItemRepo repo;

	public MenuItem getMenuItem(long menuItemId) {
		MenuItem item= repo.findByMenuItemId(menuItemId);
	
		return item;
	}
	
	
	
	
	
}
