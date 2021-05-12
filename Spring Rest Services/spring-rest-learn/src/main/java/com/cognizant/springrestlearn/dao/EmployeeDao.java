package com.cognizant.springrestlearn.dao;

import java.util.List;

import com.cognizant.springrestlearn.model.Employee;
import com.cognizant.springrestlearn.service.exception.EmployeeNotFoundException;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException;
	public void deleteEmployee(int id) throws EmployeeNotFoundException;
}
