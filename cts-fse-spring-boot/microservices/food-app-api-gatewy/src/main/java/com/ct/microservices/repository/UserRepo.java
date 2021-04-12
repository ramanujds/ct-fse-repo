package com.ct.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.microservices.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByUserName(String userName);
	
}
