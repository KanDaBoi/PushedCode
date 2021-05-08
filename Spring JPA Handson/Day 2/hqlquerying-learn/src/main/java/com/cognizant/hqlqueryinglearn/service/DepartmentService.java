package com.cognizant.hqlqueryinglearn.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;

import com.cognizant.hqlqueryinglearn.model.Department;
import com.cognizant.hqlqueryinglearn.repository.DepartmentRepository;


@Service
public class DepartmentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	public Department get(int id)
	{
		LOGGER.info("Start");
		return departmentRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Department department) {
		LOGGER.info("Start");
		departmentRepository.save(department);
		LOGGER.info("End");
	}
}