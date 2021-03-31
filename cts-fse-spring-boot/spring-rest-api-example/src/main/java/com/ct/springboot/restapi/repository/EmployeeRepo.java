package com.ct.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.springboot.restapi.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeName(String employeeName);
	
	boolean existsByEmail(String email);
	
}
