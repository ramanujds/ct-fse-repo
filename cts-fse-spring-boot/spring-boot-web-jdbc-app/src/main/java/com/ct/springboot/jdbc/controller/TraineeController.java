package com.ct.springboot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ct.springboot.jdbc.model.Trainee;
import com.ct.springboot.jdbc.service.TraineeService;

@Controller
public class TraineeController {
	
	@Autowired
	TraineeService service;

	@PostMapping("/addTrainee")
	public String addTrainee(@ModelAttribute("trainee") Trainee trainee) {
		Trainee addedTrainee=service.addTrainee(trainee);
		if(addedTrainee==null) {
			return "failure.jsp";
		}
		return "success.jsp";
		
	}
	
	
	@GetMapping("/searchTrainee")
	public String searchTrainee(@RequestParam int traineeId, Model model) {
		Trainee trainee=service.getTraineeById(traineeId);
		if(trainee==null) {
			return "failure.jsp";
		}
		model.addAttribute("trainee", trainee);
		return "success.jsp";
	}
	
	
	
}
