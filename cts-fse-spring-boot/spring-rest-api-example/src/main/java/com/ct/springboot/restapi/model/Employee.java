package com.ct.springboot.restapi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min = 5, message = "Name must contain atleast 5 characters")
	private String employeeName;
	private String email;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	

	public Employee(String employeeName, String email, LocalDate dob) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.dob = dob;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
