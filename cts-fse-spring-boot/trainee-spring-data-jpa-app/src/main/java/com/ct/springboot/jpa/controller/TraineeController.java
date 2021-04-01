package com.ct.springboot.jpa.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.springboot.jpa.model.Project;
import com.ct.springboot.jpa.model.Trainee;
import com.ct.springboot.jpa.repo.ProjectRepo;
import com.ct.springboot.jpa.service.ProjectService;
import com.ct.springboot.jpa.service.TraineeService;

@RestController
@RequestMapping("/api/trainee-service")
public class TraineeController {

	@Autowired
	private TraineeService service;
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/trainees")
	public Trainee addTraineeAndProject(@RequestBody Trainee trainee) {
		return service.saveTrainee(trainee);
	}
	
	
	
	
	
	@GetMapping("/trainees/email/{email}")
	public Trainee getTrainee(@PathVariable String email) {
		Trainee trainee=service.getTraineeByEmail(email);
		return trainee;
	}
	
}
