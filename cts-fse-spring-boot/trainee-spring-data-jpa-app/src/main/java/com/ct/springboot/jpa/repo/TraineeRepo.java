package com.ct.springboot.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ct.springboot.jpa.model.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee, Long> {
	
	@Query("from Trainee where email=:email")
	public Trainee getByEmail(String email);
	
}
