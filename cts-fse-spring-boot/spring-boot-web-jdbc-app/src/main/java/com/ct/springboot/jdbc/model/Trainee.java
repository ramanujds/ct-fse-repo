package com.ct.springboot.jdbc.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Trainee {

	private int traineeId;
	private String traineeName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
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

	public Trainee(int traineeId, String traineeName, String email, LocalDate dob) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.email = email;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", email=" + email + ", dob=" + dob
				+ "]";
	}

	
	
	
	
}
