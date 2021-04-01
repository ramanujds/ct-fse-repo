package com.ct.springboot.restapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ct.springboot.restapi.dto.EmployeeDto;
import com.ct.springboot.restapi.exception.EmployeeAlreadyExistsException;
import com.ct.springboot.restapi.exception.EmployeeNotFoundException;
import com.ct.springboot.restapi.model.Employee;
import com.ct.springboot.restapi.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	public Employee dtoToEmployee(EmployeeDto employeeDto) {
		Employee emp=new Employee();
		emp.setId(employeeDto.getId());
		emp.setDob(employeeDto.getDob());
		emp.setEmail(employeeDto.getEmail());
		emp.setEmployeeName(employeeDto.getEmployeeName());
		return emp;
	}
	
	public EmployeeDto employeeToDto(Employee employee) {
		EmployeeDto empDto=new EmployeeDto();
		empDto.setId(employee.getId());
		empDto.setDob(employee.getDob());
		empDto.setEmail(employee.getEmail());
		empDto.setEmployeeName(employee.getEmployeeName());
		LocalDate today=LocalDate.now();
		int age=today.getYear()-employee.getDob().getYear();
		empDto.setAge(age);
		return empDto;
	}

	@Override
	@Transactional
	public EmployeeDto addEmployee(Employee employee) {
		
		//Employee employee=dtoToEmployee(employeeDto);
		
			if(repo.existsByEmail(employee.getEmail())) {
				throw new EmployeeAlreadyExistsException("Employee with email ["+employee.getEmail()+"] Already Exists");
			}
		
			Employee savedEmployee=repo.save(employee);
			
			return employeeToDto(savedEmployee);
		
			
		
		
	}

	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		if(!repo.existsById(id)) {
			throw new EmployeeNotFoundException("Employee with ID ["+id+"] Not Found");
		}
		repo.deleteById(id);
	}

	@Override
	public EmployeeDto getEmployeeById(int id) throws EmployeeNotFoundException {
		
		if(!repo.existsById(id)) {
			throw new EmployeeNotFoundException("Employee with ID ["+id+"] Not Found");
		}
		Employee employee=repo.getOne(id);
		
		return employeeToDto(employee);
	}

	@Override
	public EmployeeDto getEmployeeByName(String employeeName) throws EmployeeNotFoundException {
		
		
		Employee employee=repo.findByEmployeeName(employeeName);
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee with Name ["+employeeName+"] Not Found");
		}
		return employeeToDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException {
		if(!repo.existsById(employeeDto.getId())) {
			throw new EmployeeNotFoundException("Employee with ID ["+employeeDto.getId()+"] Not Found");
		}
		Employee employee=dtoToEmployee(employeeDto);
		Employee updatedEmployee=repo.save(employee);
		return employeeToDto(updatedEmployee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeDto> employeeDtos=new ArrayList<EmployeeDto>();
		List<Employee> allEmployees=repo.findAll();
		for(Employee emp:allEmployees) {
			employeeDtos.add(employeeToDto(emp));
		}
		
		return employeeDtos;
	}


}
