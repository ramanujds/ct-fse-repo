package com.ct.springboot.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.springboot.jpa.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
