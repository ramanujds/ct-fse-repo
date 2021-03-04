package com.ct.springboot.jdbc.repository;

import java.util.List;
import java.util.Optional;

import com.ct.springboot.jdbc.model.Trainee;

public interface TraineeRepo {
	
	public Trainee addTrainee(Trainee trainee);
	public Trainee getTraineeById(int traineeId);
	public boolean deleteTraineeById(int traineeId);
	public List<Trainee> getAllTrainees();
	

}
