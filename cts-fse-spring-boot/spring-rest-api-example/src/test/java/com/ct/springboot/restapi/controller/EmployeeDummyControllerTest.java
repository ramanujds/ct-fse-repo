package com.ct.springboot.restapi.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeDummyController.class)
class EmployeeDummyControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getMessageApiTest() throws Exception {
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/api/test/message");
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals("Hello Everyone", result.getResponse().getContentAsString());
	}
	
	
	@Test
	void getEmployeeApiTest() throws Exception {
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/api/test/employee");
		
		MvcResult result=mockMvc.perform(requestBuilder)
									.andExpect(status().isOk())
									.andExpect(content().json("{}",true))
									.andReturn();
		
		
		// assertEquals("{\"id\":1001,\"employeeName\":\"Rahul\",\"email\":\"rahul@yahoo.com\",\"dob\":\"2000-02-10\"}", result.getResponse().getContentAsString());
	}

}
