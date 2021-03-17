package com.ct.springboot.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Two-Wheeler")
public class Bike extends Vehicle {

	
	private String brakeTypes;
	
	public Bike() {
		// TODO Auto-generated constructor stub
	}


	public String getBrakeTypes() {
		return brakeTypes;
	}

	public void setBrakeTypes(String brakeTypes) {
		this.brakeTypes = brakeTypes;
	}


	public Bike(int regno, String color, String brakeTypes) {
		super(regno, color,2);
		this.brakeTypes=brakeTypes;
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
