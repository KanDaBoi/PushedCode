package com.cognizant.springrestlearn.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springrestlearn.model.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	private static List<Department> DEPARTMENT_LIST;
	
	@Override
	public List<Department> getAllDepartments() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (List<Department>)ctx.getBean("departmentList");
		ctx.close();
		return DEPARTMENT_LIST;
	}
	
}
