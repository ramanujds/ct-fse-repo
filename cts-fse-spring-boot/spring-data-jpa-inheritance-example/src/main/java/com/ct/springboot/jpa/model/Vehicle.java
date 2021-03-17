package com.ct.springboot.jpa.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.context.annotation.Description;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "vehicle_type")
public class Vehicle {

	@Id
	@GeneratedValue
	private int id;
	private int regno;
	private String color;
	private int noOfWheels;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int regno, String color, int noOfWheels) {
		super();
		this.regno = regno;
		this.color = color;
		this.noOfWheels=noOfWheels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getNoOfWheels() {
		return noOfWheels;
	}

	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	
}
