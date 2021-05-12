package com.cognizant.springrestlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrestlearn.model.Department;
import com.cognizant.springrestlearn.service.DepartmentService;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value="/departments")
	public List<Department> getAllDepartments()
	{
		LOGGER.debug("Start of department controller");
		return departmentService.getAllDepartments();
	}
}
