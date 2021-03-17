package com.ct.springboot.jpa.repo;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ct.springboot.jpa.model.Bike;
import com.ct.springboot.jpa.model.Car;
import com.ct.springboot.jpa.model.Vehicle;

@Repository
public class VehicleRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void saveVehicle(Vehicle vehicle) {
		em.persist(vehicle);
	}
	
	@Transactional
	public void saveBike(Bike bike) {
		em.persist(bike);
	}
	
	@Transactional
	public void saveCar(Car car) {
		em.persist(car);
	}
	
	
	
	
}
