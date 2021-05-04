package com.cognizant.component.processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.component.processing.model.ProcessResponse;

//@Repository
public interface ProcessResponseRepository extends JpaRepository<ProcessResponse,Integer> {

}
