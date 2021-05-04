package com.ct.microservices.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ct.microservices.model.User;
import com.ct.microservices.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo repo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=repo.findByUserName(username);
		
		log.info(user.toString());
		
		return new AuthUserDetails(user);
	}

	@PostConstruct
	@Transactional
	public void addUser() {
		if(repo.findAll().size()==0) {
		User user=new User(1, "cts", "password", false, true, false, true, "ADMIN");
		User user2=new User(2, "rahul", "password", false, true, false, true, "USER");
		repo.save(user);
		repo.save(user2);
		}
	}
	
	
}
