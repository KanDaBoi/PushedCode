package com.cognizant.fetchlazyquerylearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.fetchlazyquerylearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
@Query(value="select e from Employee e left join fetch e.department d left join fetch e.skillList where e.permanent = 1")
public List<Employee> getAllPermanentEmployees();
}
