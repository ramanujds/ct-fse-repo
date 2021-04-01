package com.ct.springboot.jpa.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ct.springboot.jpa.model.Project;
import com.ct.springboot.jpa.model.Trainee;
import com.ct.springboot.jpa.repo.ProjectRepo;
import com.ct.springboot.jpa.repo.TraineeRepo;
import com.ct.springboot.jpa.repo.TraineeRepoImpl;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	private TraineeRepo repo;
	
	@Autowired
	private ProjectRepo pRepo;
	
	@Autowired
	private TraineeRepoImpl tRepoImpl;
	
	@PostConstruct
	@Transactional
	public void init() {
//		
//		Trainee trainee=new Trainee(10001L, "Mahesh", "mahesh@yahoo.com", LocalDate.of(2000, 2, 10));
//		Trainee trainee2=new Trainee(10002L, "Pritam", "pritam@yahoo.com", LocalDate.of(2001, 12, 25));
//		Project project=new Project(501, "Tru Yum", LocalDate.now());
//		project.getTrainees().add(trainee);
//		project.getTrainees().add(trainee2);
//		trainee.setProject(project);
//		trainee2.setProject(project);
		
		
//		Trainee trainee=tRepoImpl.getTraineeById(10001L);
//		Trainee trainee2=tRepoImpl.getTraineeById(10002L);
//		Project project=tRepoImpl.getProject(501);
//		trainee.setProject(project);
//		trainee2.setProject(project);
		
//		repo.save(trainee);
//		repo.save(trainee2);
		
		
//		trainee.setProject(project);
//		
//		pRepo.save(project);
		
//		Project p=tRepoImpl.getProject(501);
//		System.out.println(p);
		
//		Trainee t1=tRepoImpl.getTraineeById(10001L);
//		System.out.println(t1);
		
	}
	
	
	
	@Override
	public Trainee saveTrainee(Trainee trainee) {
//		if(repo.existsById(trainee.getTraineeId())) {
//			return trainee;
//		}
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
