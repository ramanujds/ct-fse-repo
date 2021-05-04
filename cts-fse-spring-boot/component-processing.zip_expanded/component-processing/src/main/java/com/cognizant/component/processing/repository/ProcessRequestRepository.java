package com.cognizant.component.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.component.processing.model.ProcessRequest;

//@Repository
public interface ProcessRequestRepository extends JpaRepository<ProcessRequest,Integer> {

	public ProcessRequest findByUserId(int userId);
	
}
