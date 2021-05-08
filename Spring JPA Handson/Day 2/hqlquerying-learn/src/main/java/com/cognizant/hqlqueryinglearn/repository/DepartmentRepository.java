package com.cognizant.hqlqueryinglearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hqlqueryinglearn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	
}
