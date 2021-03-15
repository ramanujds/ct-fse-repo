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
	
	@Override
	public Trainee saveTrainee(Trainee trainee) {
		if(repo.existsById(trainee.getTraineeId())) {
			return trainee;
		}
		return repo.save(trainee);
	}


	@Override
	public Trainee getTraineeById(long traineeId) {
		return repo.getOne(traineeId);
	}
	


	@Override
	public void deleteTrainee(long traineeId) {
		repo.deleteById(traineeId);
		
	}


	@Override
	public Trainee updateTrainee(Trainee trainee) {
		return repo.save(trainee);
	}


	@Override
	public List<Trainee> getAllTrainees() {
		// TODO Auto-generated method stub
		return repo.findAll();
		}
	
	@Override
	public Trainee getTraineeByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.getByEmail(email);
	}

}
