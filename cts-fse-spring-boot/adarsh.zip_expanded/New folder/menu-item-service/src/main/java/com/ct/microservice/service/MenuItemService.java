package com.ct.microservice.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.ct.microservice.model.MenuItem;
//import com.ct.microservices.model.RecipeMenu;
import com.ct.microservice.repository.MenuItemRepo;

@Service
public class MenuItemService {
	@Autowired
	Environment env;
//	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	MenuItemRepo repo;

	public MenuItem getMenuItem(long menuItemId) {
		MenuItem item= repo.findByMenuItemId(menuItemId);
		int port=Integer.parseInt(env.getProperty("local.server.port"));
		item.setPort(port);

		
		return item;
	}
	

	
	
}