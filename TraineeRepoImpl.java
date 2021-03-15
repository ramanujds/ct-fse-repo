package com.ct.springboot.jpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ct.springboot.jpa.model.Trainee;

@Repository
public class TraineeRepoImpl implements TraineeRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Trainee saveTrainee(Trainee trainee) {
		entityManager.persist(trainee);
		return trainee;
	}

	@Override
	public Trainee getTraineeById(long traineeId) {
		return entityManager.find(Trainee.class, traineeId);
	}

	@Override
	public void deleteTrainee(long traineeId) {
	
		Trainee trainee=entityManager.find(Trainee.class, traineeId);
		entityManager.remove(trainee);

	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		entityManager.merge(trainee);
		return trainee;
	}

	@Override
	public List<Trainee> getAllTrainees() {
		
		TypedQuery<Trainee> getAll=entityManager.createQuery("from Trainee",Trainee.class);
		return getAll.getResultList();
		
	}

}
