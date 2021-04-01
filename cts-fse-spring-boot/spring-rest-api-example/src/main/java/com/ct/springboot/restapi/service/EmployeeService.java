package com.ct.springboot.restapi.service;

import java.util.List;

import com.ct.springboot.restapi.dto.EmployeeDto;
import com.ct.springboot.restapi.exception.EmployeeNotFoundException;
import com.ct.springboot.restapi.model.Employee;

public interface EmployeeService {

	public EmployeeDto addEmployee(Employee employee) ;
	public void deleteEmployee(int id) throws EmployeeNotFoundException;
	public EmployeeDto getEmployeeById(int id) throws EmployeeNotFoundException;
	public EmployeeDto getEmployeeByName(String employeeName) throws EmployeeNotFoundException ;
	public EmployeeDto updateEmployee(EmployeeDto employee) throws EmployeeNotFoundException ;
	public List<EmployeeDto> 	getAllEmployees();
	
	
}
