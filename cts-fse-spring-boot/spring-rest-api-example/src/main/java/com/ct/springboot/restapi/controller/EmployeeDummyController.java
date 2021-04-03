package com.ct.springboot.restapi.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.springboot.restapi.model.Employee;

@RestController
@RequestMapping("/api/test")
public class EmployeeDummyController {

	@GetMapping("/message")
	public String getMessage() {
		System.out.println("getMessage() Invoked");
		return "Hello Everyone";
	}
	
	@GetMapping("/employee")
	public Employee getEmployee() {
		
		Employee emp=new Employee("Rahul", "rahul@yahoo.com", LocalDate.of(2000, 2, 10));
		
		emp.setId(1001);
		return emp;
	}
	
	
}
