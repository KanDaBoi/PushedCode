package com.cognizant.fetchlazyquerylearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.fetchlazyquerylearn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	
}
