package com.cognizant.hqlqueryinglearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.hqlqueryinglearn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
@Query(value="select e from Employee e left join fetch e.department d left join fetch e.skillList where e.permanent = 1")
public List<Employee> getAllPermanentEmployees();

@Query(value="select AVG(e.salary) from Employee e where e.department.id = :id")
public double getAverageSalary(@Param("id") int id);

@Query(value="select * from Employee", nativeQuery = true)
public List<Employee> getAllEmployeesNative();
}
