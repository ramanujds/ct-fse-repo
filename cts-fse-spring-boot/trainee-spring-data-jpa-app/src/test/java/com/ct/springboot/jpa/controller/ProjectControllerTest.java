package com.ct.springboot.jpa.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ct.springboot.jpa.model.Project;
import com.ct.springboot.jpa.service.ProjectService;
@SpringBootTest
class ProjectControllerTest {

	@Autowired
	ProjectService service;
	@Test
	void testGetProject() {
		
		assertEquals(12221l, service.getProjectById(12221l).getProjectId());
	}

	@Test
	void testSaveProjectAndTrainee() {
		Project p=new Project();
		
		assertEquals(p, service.saveProject(p));
	}

	@Test
	void testSaveProject() {
		Project p=new Project();
	
		assertEquals(p, service.saveProject(p));
	}

}
