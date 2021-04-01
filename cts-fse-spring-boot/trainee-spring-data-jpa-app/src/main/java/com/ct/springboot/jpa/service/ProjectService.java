package com.ct.springboot.jpa.service;

import com.ct.springboot.jpa.model.Project;

public interface ProjectService {

	public Project saveProject(Project project);
	public Project getProjectById(long projectId);
	
	
}
