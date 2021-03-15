package com.ct.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ct.springboot.jpa.model.Trainee;
import com.ct.springboot.jpa.service.TraineeService;

@Controller
public class TraineeController {

	@Autowired
	private TraineeService service;
	
	@PostMapping("/trainees/add")
	public String addTrainee(@ModelAttribute("trainee") Trainee trainee) {
		service.saveTrainee(trainee);
		return "success.jsp";
	}
	
	@GetMapping("/trainees/find")
	public String getTrainee(@RequestParam long traineeId, Model m) {
		Trainee trainee=service.getTraineeById(traineeId);
		m.addAttribute("trainee",trainee);
		return "show-trainee.jsp";
	}
	
	@GetMapping("/trainees/email/{email}")
	@ResponseBody
	public Trainee getTrainee(@PathVariable String email) {
		Trainee trainee=service.getTraineeByEmail(email);
		return trainee;
	}
	
}
