package com.ct.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ct.springboot.jpa.model.Trainee;
import com.ct.springboot.jpa.repo.TraineeRepo;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	private TraineeRepo repo;
	
	@Transactional
	@Override
	public Trainee saveTrainee(Trainee trainee) {
		return repo.saveTrainee(trainee);
	}

	@Transactional
	@Override
	public Trainee getTraineeById(long traineeId) {
		return repo.getTraineeById(traineeId);
	}
	

	@Transactional
	@Override
	public void deleteTrainee(long traineeId) {
		repo.deleteTrainee(traineeId);
		
	}

	@Transactional
	@Override
	public Trainee updateTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Trainee> getAllTrainees() {
		// TODO Auto-generated method stub
		return repo.getAllTrainees();
		}

}
