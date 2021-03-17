package com.ct.springboot.jpa.service;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ct.springboot.jpa.model.Bike;
import com.ct.springboot.jpa.model.Car;
import com.ct.springboot.jpa.model.Vehicle;
import com.ct.springboot.jpa.repo.VehicleRepo;
@Service
@Transactional
public class VehicleService {

	@Autowired
	VehicleRepo repo;
	
//	@Transactional
//	public void saveVehicle(Vehicle vehicle) {
//		repo.saveVehicle(vehicle);
//	}
	
	
	
	
	@PostConstruct
	
	public void init() {
		Vehicle bike=new Bike(10002, "Red", "Dual ABS");
		Vehicle car=new Car(20001,"Black","SONY");
		repo.saveVehicle(bike);
		repo.saveVehicle(car);
		
	}
	
	
}
