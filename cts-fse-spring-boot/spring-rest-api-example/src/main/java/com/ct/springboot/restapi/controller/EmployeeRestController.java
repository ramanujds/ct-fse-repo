package com.ct.springboot.restapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ct.springboot.restapi.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	List<Employee> employees = new ArrayList<Employee>();

	@PostConstruct
	public void init() {
		employees.add(new Employee("Gaurav", "gaurav@yahoo.com", 25));
		employees.add(new Employee("Vinay", "vinay@yahoo.com", 28));
		employees.add(new Employee("Mohan", "mohan@yahoo.com", 27));
	}

	@GetMapping("/employee/{employeeName}")
	public Employee getEmployee(@PathVariable String employeeName) {
	
		Employee emp= employees.stream().filter(e->e.getEmployeeName().equalsIgnoreCase(employeeName)).findFirst().orElse(null);
		if(emp==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return emp;
	}

	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee emp) {
		employees.add(emp);
		return emp;
	}

	@GetMapping(value = "/employees", consumes = "application/json", produces = "application/json")
	public List<Employee> getEmployees() {
		return employees;
	}

}
