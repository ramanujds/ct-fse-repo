package com.ct.springboot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.springboot.jpa.model.Project;
import com.ct.springboot.jpa.repo.ProjectRepo;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo projectRepo;
	
	@Override
	public Project getProjectById(long projectId) {
		// TODO Auto-generated method stub
		return projectRepo.getOne(projectId);
	}
	
	@Override
	public Project saveProject(Project project) {
		return projectRepo.save(project);
	}
	
}
