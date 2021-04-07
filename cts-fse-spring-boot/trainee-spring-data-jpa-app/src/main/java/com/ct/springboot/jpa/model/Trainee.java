package com.ct.springboot.jpa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Table(name = "trainee_info")
@AllArgsConstructor
public class Trainee {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainee_id")
	private long traineeId;
	@Column(name = "trainee_name", length = 30, nullable = false)
	private String traineeName;
	@Column(name = "email", length = 50, unique = true)
	private String email;
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Project.class)
//	private Project project;
	
		
	
	
}
