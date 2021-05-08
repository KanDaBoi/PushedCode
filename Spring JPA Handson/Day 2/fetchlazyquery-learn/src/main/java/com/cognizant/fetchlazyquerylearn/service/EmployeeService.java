package com.cognizant.fetchlazyquerylearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.fetchlazyquerylearn.model.Employee;
import com.cognizant.fetchlazyquerylearn.repository.EmployeeRepository;


@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(int id)
	{
		LOGGER.info("Start");
		return employeeRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Employee employee) {
		LOGGER.info("Start");
		employeeRepository.save(employee);
		LOGGER.info("End");
	}
	
	@Transactional
	public List<Employee> getAllPermanentEmployees()
	{
		List<Employee> employeeList = employeeRepository.getAllPermanentEmployees();
		return employeeList;
	}
}
