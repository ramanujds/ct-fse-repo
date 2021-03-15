package com.ct.springboot.jpa.service;

import java.util.List;

import com.ct.springboot.jpa.model.Trainee;

public interface TraineeService {


	public Trainee saveTrainee(Trainee trainee);
	public Trainee getTraineeById(long traineeId);
	public void deleteTrainee(long traineeId);
	public Trainee updateTrainee(Trainee trainee);
	public List<Trainee> getAllTrainees();
	public Trainee getTraineeByEmail(String email);
	
}
