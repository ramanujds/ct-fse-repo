package com.ct.springboot.jpa.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RestController;

import com.ct.springboot.jpa.service.TraineeService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TestController.class)
public class ControllerTest {

	 @Autowired
	 private MockMvc mockMvc;
	 
	 
	 @MockBean
	 private TraineeService service;
	 
	 @Test
	 public void testGetTrainee() throws Exception {
		 RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/api/hello");
		
		 MvcResult result=mockMvc.perform(requestBuilder)
				 						.andExpect(status().isOk())
				 						.andExpect(content().string("Hello World"))
				 						.andReturn();
//		 assertEquals("Hello World", result.getResponse().getContentAsString());
		 
		 assertEquals("Hello World", result.getResponse().getContentAsString());
		 
		// mockMvc.per
	 }
	 
	 
	 @Test
	 public void testTrainee() throws Exception{
		 RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/api/dummy-trainee");
		 
		 
		 
//		 MvcResult result=mockMvc.perform(requestBuilder)
//				 					.andExpect(content().json("{\"traineeId\":10211,\"traineeName\":\"Tushar\",\"email\":\"tushar@gmail.com\"}"))
//				 					.andReturn();
		 
		 
		 MvcResult result=mockMvc.perform(requestBuilder)
					.andExpect(content().json("{\"traineeId\":10211,\"traineeName\":\"Tushar\",\"email\":\"tushar@gmail.com\"}"))
					.andReturn();
		
	 }
	 
	 

}
