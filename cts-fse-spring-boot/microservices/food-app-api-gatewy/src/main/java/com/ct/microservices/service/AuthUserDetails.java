package com.ct.microservices.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ct.microservices.model.User;

public class AuthUserDetails implements UserDetails {

	private String userName;
	private String password;
	private boolean isExpired;
	private boolean isActive;
	private boolean isCredExpired;
	private boolean isEnabled;
	private List<GrantedAuthority> auths;
	
	public AuthUserDetails(User user) {
		this.userName=user.getUserName();
		this.password=user.getPassword();
		this.isActive=user.isActive();
		this.isCredExpired=user.isCredExpired();
		this.isEnabled=user.isEnabled();
		this.auths=Arrays.stream(user.getRole().split(","))
				.map(role->"ROLE_"+role)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return auths;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return !isExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return isActive;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return !isCredExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

}
