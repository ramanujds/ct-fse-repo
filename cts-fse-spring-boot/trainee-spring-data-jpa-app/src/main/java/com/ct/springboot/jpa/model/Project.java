package com.ct.springboot.jpa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Project {

	@Id
	private long projectId;
	 
	private String projectTitle;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate stratDate;
	
	@Transient
	private String projectUpdate;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_trainees_list",  joinColumns = @JoinColumn(name = "trainee_id"), inverseJoinColumns = @JoinColumn(name = "project_id")) 
	private Set<Trainee> trainees;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(long projectId, String projectTitle, LocalDate stratDate) {
		super();
		this.projectId = projectId;
		this.projectTitle = projectTitle;
		this.stratDate = stratDate;
	}
	
	

	public String getProjectUpdate() {
		return projectUpdate;
	}

	public void setProjectUpdate(String projectUpdate) {
		this.projectUpdate = projectUpdate;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
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
