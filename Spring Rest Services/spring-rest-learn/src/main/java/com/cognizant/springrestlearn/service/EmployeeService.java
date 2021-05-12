package com.cognizant.springrestlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.springrestlearn.dao.EmployeeDao;
import com.cognizant.springrestlearn.dao.EmployeeDaoImpl;
import com.cognizant.springrestlearn.model.Employee;
import com.cognizant.springrestlearn.service.exception.EmployeeNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Transactional
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	@Transactional
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		employeeDao.updateEmployee(employee);
	}
	
	@Transactional
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		employeeDao.deleteEmployee(id);
	}
}
