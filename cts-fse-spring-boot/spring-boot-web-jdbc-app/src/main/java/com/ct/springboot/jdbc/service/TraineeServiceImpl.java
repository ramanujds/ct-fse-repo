package com.ct.springboot.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.springboot.jdbc.model.Trainee;
import com.ct.springboot.jdbc.repository.TraineeRepo;
@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	TraineeRepo repo;
	
	
	@Override
	public Trainee addTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return repo.addTrainee(trainee);
	}

	@Override
	public Trainee getTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		return repo.getTraineeById(traineeId);
	}

	@Override
	public boolean deleteTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trainee> getAllTrainees() {
		// TODO Auto-generated method stub
		return repo.getAllTrainees();
	}

}
