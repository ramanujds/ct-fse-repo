package com.ct.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.microservice.model.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

	MenuItem findByMenuItemId(long menuItemId);
	
	
}