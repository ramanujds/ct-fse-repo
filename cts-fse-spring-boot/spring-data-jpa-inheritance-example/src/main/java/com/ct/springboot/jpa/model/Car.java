package com.ct.springboot.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Four-Wheeler")
public class Car extends Vehicle {

	
	private String musicSystem;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	

	public String getMusicSystem() {
		return musicSystem;
	}

	public void setMusicSystem(String musicSystem) {
		this.musicSystem = musicSystem;
	}



	public Car(int regno, String color, String musicSystem) {
		super(regno, color,4);
		this.musicSystem=musicSystem;
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
