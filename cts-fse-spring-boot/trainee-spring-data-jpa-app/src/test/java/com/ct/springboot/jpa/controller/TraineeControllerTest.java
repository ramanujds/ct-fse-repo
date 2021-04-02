package com.ct.springboot.jpa.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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

import com.ct.springboot.jpa.model.Trainee;
import com.ct.springboot.jpa.service.TraineeService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TraineeController.class)
public class TraineeControllerTest {

	 @Autowired
	 private MockMvc mockMvc;
	 
	 
	 @MockBean
	 private TraineeService service;
	 
	 @Test
	 public void testGetTrainee() throws Exception {
		 RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/api/trainee-service/trainees/email/rahul@yahoo.com");
		
		 when(service.getTraineeByEmail("rahul@yahoo.com")).thenReturn(new Trainee(10001, "Rahul", "rahul@yahoo.com", LocalDate.of(1995, 02, 10)));
		 
		 MvcResult result=mockMvc.perform(requestBuilder)
				 						.andExpect(status().isOk())
				 						.andExpect(content().json("{\"traineeId\":10001,\"traineeName\":\"Rahul\",\"email\":\"rahul@yahoo.com\",\"dob\":\"1995-02-10\"}"))
				 						.andReturn();

	 }
	 
	 
	
	 

}
