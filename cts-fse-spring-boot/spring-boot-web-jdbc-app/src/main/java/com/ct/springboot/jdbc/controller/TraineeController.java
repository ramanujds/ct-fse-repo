package com.ct.springboot.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ct.springboot.jdbc.exception.TraineeNotFoundException;
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
		try{
			Trainee trainee=service.getTraineeById(traineeId);
		
		model.addAttribute("trainee", trainee);
		return "success.jsp";
		}
		catch (TraineeNotFoundException e) {
			model.addAttribute("message",e.getMessage());
			model.addAttribute("status", HttpStatus.NOT_FOUND.value());
			return "error";
		}
	}
	
	@GetMapping("/showall")
	public String showAllTrainees(Model m) {
		List<Trainee> allTrainees=service.getAllTrainees();
		m.addAttribute("trainees", allTrainees);
		return "show-all-trainees.jsp";
	}
	
	
}
