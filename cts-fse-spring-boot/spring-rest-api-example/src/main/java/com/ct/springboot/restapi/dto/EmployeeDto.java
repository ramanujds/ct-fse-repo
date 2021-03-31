package com.ct.springboot.restapi.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeDto {

	private int id;
	
	@Size(min = 5)
	private String employeeName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private int age;
	
	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public EmployeeDto(String employeeName, String email, LocalDate dob, int age) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", employeeName=" + employeeName + ", email=" + email + ", dob=" + dob
				+ ", age=" + age + "]";
	}
	
	
	
}
