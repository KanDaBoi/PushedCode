package com.cognizant.springrestlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springrestlearn.dao.DepartmentDao;
import com.cognizant.springrestlearn.dao.DepartmentDaoImpl;
import com.cognizant.springrestlearn.model.Department;

@Service
public class DepartmentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Transactional
	public List<Department> getAllDepartments(){
		LOGGER.debug("Start of department service");
		return this.departmentDao.getAllDepartments();
	}
}
