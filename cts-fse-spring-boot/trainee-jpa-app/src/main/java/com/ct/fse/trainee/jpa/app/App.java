package com.ct.fse.trainee.jpa.app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ct.fse.trainee.jpa.app.model.Trainee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	EntityManagerFactory factory=Persistence.createEntityManagerFactory("trainee-unit");
    	EntityManager entityManager=factory.createEntityManager();
    	EntityTransaction tx=entityManager.getTransaction();
//    	
//    	Trainee trainee1=new Trainee( "Pritam Sharma", "pritam@yahoo.com", LocalDate.of(1995, 4, 2));
//    	Trainee trainee2=new Trainee( "Harsh Dutta", "harsh@yahoo.com", LocalDate.of(1999, 8, 2));
//    	Trainee trainee3=new Trainee( "Gaurav Reddy", "gaurav@yahoo.com", LocalDate.of(1992, 8, 12));
//    	tx.begin();
//    	
//    	//Saving a new Trainee
//    	entityManager.persist(trainee1);
//    	entityManager.persist(trainee2);
//    	entityManager.persist(trainee3);
//    	
//    	tx.commit();
//    	System.out.println("Trainee Added");
    	
//    	// Fetching Trainee
//    	Trainee trainee=entityManager.find(Trainee.class, 100121L);
//    	System.out.println(trainee);
    	
//    	// Deleting Trainee
//    	
//    	Trainee trainee=entityManager.find(Trainee.class, 100121L);
//    	tx.begin();
//    	entityManager.remove(trainee);
//    	tx.commit();
//    	System.out.println("Trainee Removed");
    	
    	// Updating Data
    	
//    	Trainee trainee=entityManager.find(Trainee.class, 100122L);
//    	trainee.setTraineeName("Mohit Tiwari");
//    	tx.begin();
//    	entityManager.persist(trainee);
//    	tx.commit();
    	
    	
    	// Fetching all the trainees
    	
//    	Query queryGetAll=entityManager.createQuery("from Trainee");
//    	List<Trainee> trainees= queryGetAll.getResultList();
//    	
//    	TypedQuery<Trainee> queryGetAll=entityManager.createQuery("from Trainee",Trainee.class);
//    	List<Trainee> trainees= queryGetAll.getResultList();
//    	
//    	trainees.forEach(System.out::println);
    	
    	// Named Queries
    	
//    	TypedQuery<Trainee> query=entityManager.createNamedQuery("getTraineeByEmail", Trainee.class);
//    	query.setParameter("email", "harsh@yahoo.com");
//    	
//    	Trainee trainee=query.getSingleResult();
//    	System.out.println(trainee);
    
    	// Criteria Select
    	
//    	CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
//    	
//    	CriteriaQuery<Trainee> cQuery=criteriaBuilder.createQuery(Trainee.class);
//    	
//    	Root<Trainee> root=cQuery.from(Trainee.class);
//    	
//    	CriteriaQuery<Trainee> selectAll=cQuery.select(root);
//    	Query select=entityManager.createQuery(selectAll);
//    	
//    	List<Trainee> trainees=select.getResultList();
//    	trainees.forEach(System.out::println);
    
    	// Working with Dates
    	
//    	TypedQuery<Trainee> query=entityManager.createNamedQuery("findTraineesWithDob", Trainee.class);
//    	query.setParameter("date1", LocalDate.of(1994, 1, 1));
//    	query.setParameter("date2", LocalDate.of(2000, 1, 1));
//    	List<Trainee> trainees=query.getResultList();
//    	trainees.forEach(System.out::println);
    	
    }
}
