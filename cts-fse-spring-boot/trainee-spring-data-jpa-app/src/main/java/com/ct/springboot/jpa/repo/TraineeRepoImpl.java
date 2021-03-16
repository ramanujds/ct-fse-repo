package com.ct.springboot.jpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ct.springboot.jpa.model.Project;
import com.ct.springboot.jpa.model.Trainee;

@Repository
public class TraineeRepoImpl {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Project getProject(long projectId) {
		return entityManager.find(Project.class, projectId);
	}

	public Trainee saveTrainee(Trainee trainee) {
		entityManager.persist(trainee);
		return trainee;
	}


	public Trainee getTraineeById(long traineeId) {
		return entityManager.find(Trainee.class, traineeId);
	}

	public void deleteTrainee(long traineeId) {
	
		Trainee trainee=entityManager.find(Trainee.class, traineeId);
		entityManager.remove(trainee);

	}


	public Trainee updateTrainee(Trainee trainee) {
		entityManager.merge(trainee);
		return trainee;
	}


	public List<Trainee> getAllTrainees() {
		
		TypedQuery<Trainee> getAll=entityManager.createQuery("from Trainee",Trainee.class);
		return getAll.getResultList();
		
	}

}
