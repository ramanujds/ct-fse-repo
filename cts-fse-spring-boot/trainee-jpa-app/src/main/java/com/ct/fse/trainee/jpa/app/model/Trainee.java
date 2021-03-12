package com.ct.fse.trainee.jpa.app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "trainee_data")
@NamedQueries({
		@NamedQuery(name = "getTraineeByEmail", query = "from Trainee where email=:email"),
		@NamedQuery(name = "getTraineeByName", query = "from Trainee where traineName=:traineeName"),
		@NamedQuery(name = "findTraineesWithDob", query = "from Trainee where dob between :date1 and :date2")
		}
		)
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainee_id")
	private long traineeId;
	@Column(name = "trainee_name", length = 30, nullable = false)
	private String traineeName;
	@Column(name = "email", length = 50, unique = true)
	private String email;
	@Column(name = "birth_date")
	private LocalDate dob;
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Trainee(String traineeName, String email, LocalDate dob) {
		super();
		
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
