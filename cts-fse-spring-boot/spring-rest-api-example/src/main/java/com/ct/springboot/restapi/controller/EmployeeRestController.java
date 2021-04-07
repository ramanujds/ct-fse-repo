package com.ct.springboot.restapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ct.springboot.restapi.dto.EmployeeDto;
import com.ct.springboot.restapi.exception.EmployeeNotFoundException;
import com.ct.springboot.restapi.model.Employee;
import com.ct.springboot.restapi.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeRestController {

	
	
	@Autowired
	EmployeeService service;
	
	
	
	@PostConstruct
	public void init() {
	}

	@GetMapping("/employees/employee-name/{employeeName}")
	public EmployeeDto getEmployee(@PathVariable String employeeName) throws EmployeeNotFoundException {
	log.info("Employee Fetched");
	return service.getEmployeeByName(employeeName);
		
	}

	@PostMapping(value="/employees", consumes =  {"application/xml", "application/json"})
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDto addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}

	@GetMapping(value = "/employees", consumes = "application/json", produces = "application/json")
	public List<EmployeeDto> getEmployees() {
		return service.getAllEmployees();
	}
	
	@DeleteMapping("/employees/id/{id}")
	public void deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException {
		service.deleteEmployee(id);
	}
	
	@GetMapping("/employees/id/{id}")
	public EmployeeDto getEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException {
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto emp) throws EmployeeNotFoundException {

			EmployeeDto empDto=service.updateEmployee(emp);
			return new ResponseEntity<EmployeeDto>(empDto, HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping(value = "/employees", produces = {"application/xml", "application/json"})
	public List<EmployeeDto> getAllEmployees(){
		return service.getAllEmployees();
	}
	

}
