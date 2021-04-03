package com.ct.springboot.restapi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ct.springboot.restapi.dto.EmployeeDto;
import com.ct.springboot.restapi.exception.EmployeeNotFoundException;
import com.ct.springboot.restapi.model.Employee;
import com.ct.springboot.restapi.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeRestController.class)
class EmployeeRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService service;
	
	
	@Test
	public void testTraineeApi() throws Exception {
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/api/employees/id/1001");
		EmployeeDto emp=new EmployeeDto("Rahul", "rahul@yahoo.com", LocalDate.of(2000, 2, 10),10);
		emp.setId(1001);
		when(service.getEmployeeById(1001)).thenReturn(emp);
		MvcResult result=mockMvc.perform(requestBuilder)
								.andExpect(content().json("{\"id\":1001,\"employeeName\":\"Rahul\",\"email\":\"rahul@yahoo.com\",\"dob\":\"2000-02-10\"}"))
								.andReturn();
		
		}
	
	
}
