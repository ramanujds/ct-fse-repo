package com.ct.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.microservices.model.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

	MenuItem findByMenuItemId(long menuItemId);
	
	
}
