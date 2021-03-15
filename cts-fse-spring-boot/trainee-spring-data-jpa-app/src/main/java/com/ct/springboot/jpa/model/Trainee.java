package com.ct.springboot.jpa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;

@Entity
@Table(name = "trainee_info")
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
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Trainee(long traineeId,String traineeName, String email, LocalDate dob) {
		super();
		this.traineeId=traineeId;
		this.traineeName = traineeName;
		this.email = email;
		this.dob = dob;
	}



	public long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", email=" + email + ", dob=" + dob
				+ "]";
	}
	
	
	
	
}
