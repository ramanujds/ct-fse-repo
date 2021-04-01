package com.ct.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.springboot.jpa.model.Project;
import com.ct.springboot.jpa.model.Trainee;
import com.ct.springboot.jpa.service.ProjectService;
import com.ct.springboot.jpa.service.TraineeService;

@RestController
@RequestMapping("/api/project-service")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@Autowired
	private TraineeService traineeService;
	
	
	@GetMapping("/projects/{projectId}")
	public Project getProject(@PathVariable long projectId) {
		return service.getProjectById(projectId);
	}
	
	@PostMapping("/projects")
	public Project saveProjectAndTrainee(@RequestBody Project project) {
		return service.saveProject(project);
	}
	
	@PostMapping("/projects/trainees/{traineeId}")
	public Project saveProject(@RequestBody Project project, @PathVariable long traineeId) {
		Trainee trainee=traineeService.getTraineeById(traineeId);
		project.getTrainees().add(trainee);
		return service.saveProject(project);
	}
	
	
}
