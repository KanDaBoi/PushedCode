package com.cognizant.relationquerylearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.relationquerylearn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	
}
