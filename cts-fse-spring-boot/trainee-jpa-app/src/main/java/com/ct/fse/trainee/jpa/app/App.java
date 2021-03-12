package com.ct.fse.trainee.jpa.app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
    	
//    	Trainee trainee=new Trainee(100122, "Mohit Sharma", "mohit@yahho.com", LocalDate.of(1998, 11, 12));
//    	tx.begin();
//    	
//    	//Saving a new Trainee
//    	entityManager.persist(trainee);
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
    	
    	
    	
    }
}
