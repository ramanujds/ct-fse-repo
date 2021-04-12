package com.ct.microservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id @GeneratedValue
	private long id;
	@Column(unique = true)
	private String userName;
	private String password;
	private boolean isExpired;
	private boolean isActive;
	private boolean isCredExpired;
	private boolean isEnabled;
	private String role;
	
	
}
