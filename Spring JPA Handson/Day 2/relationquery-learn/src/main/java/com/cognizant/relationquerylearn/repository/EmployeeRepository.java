package com.cognizant.relationquerylearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.relationquerylearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
}
