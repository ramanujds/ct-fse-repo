package com.ct.springboot.jpa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Project {

	@Id
	private long projectId;
	
	private String projectTitle;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate stratDate;
	
	@OneToMany(fetch = FetchType.EAGER)
	
	private List<Trainee> trainees=new ArrayList<>();
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(long projectId, String projectTitle, LocalDate stratDate) {
		super();
		this.projectId = projectId;
		this.projectTitle = projectTitle;
		this.stratDate = stratDate;
	}
	
	

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public LocalDate getStratDate() {
		return stratDate;
	}

	public void setStratDate(LocalDate stratDate) {
		this.stratDate = stratDate;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + ", stratDate=" + stratDate
				+ ", trainees=" + trainees + "]";
	}

	
	
	
	
}
