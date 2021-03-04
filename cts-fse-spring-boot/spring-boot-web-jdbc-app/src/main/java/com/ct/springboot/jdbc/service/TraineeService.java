package com.ct.springboot.jdbc.service;

import java.util.List;

import com.ct.springboot.jdbc.model.Trainee;

public interface TraineeService {

	public Trainee addTrainee(Trainee trainee);
	public Trainee getTraineeById(int traineeId);
	public boolean deleteTraineeById(int traineeId);
	public List<Trainee> getAllTrainees();
	
	
}
