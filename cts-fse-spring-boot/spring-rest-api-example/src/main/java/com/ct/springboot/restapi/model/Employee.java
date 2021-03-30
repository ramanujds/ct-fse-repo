package com.ct.springboot.restapi.model;

public class Employee {
	
	private String employeeName;
	private String email;
	private int age;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeName, String email, int age) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
