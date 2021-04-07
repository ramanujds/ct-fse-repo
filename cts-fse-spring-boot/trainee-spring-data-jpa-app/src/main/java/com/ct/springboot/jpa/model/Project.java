package com.ct.springboot.jpa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

import lombok.Data;

@Data
@Entity
public class Project {

	@Id
	private long projectId;
	 
	private String projectTitle;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate stratDate;
	
//	@Transient
//	private String projectUpdate;
//	
	
	
	@OneToMany(cascade = CascadeType.ALL)
//	//@JoinTable(name = "project_trainees_list",  joinColumns = @JoinColumn(name = "trainee_id"), inverseJoinColumns = @JoinColumn(name = "project_id")) 
	private Set<Trainee> trainees=new HashSet<>();
//	

	public Set<Trainee> getTrainees() {
		// TODO Auto-generated method stub
		return trainees;
	}
	
	
}
