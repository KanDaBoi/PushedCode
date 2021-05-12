package com.cognizant.springrestlearn.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springrestlearn.model.Employee;
import com.cognizant.springrestlearn.service.exception.EmployeeNotFoundException;

public class EmployeeDaoImpl implements EmployeeDao {
	private static List<Employee> EMPLOYEE_LIST;
	public EmployeeDaoImpl() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (List<Employee>)ctx.getBean("employeeList");
		ctx.close();
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return EMPLOYEE_LIST;
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		boolean listModified = false;
		int index = -1;
		for(Employee listEmployee: EMPLOYEE_LIST) {
			if(listEmployee.getId() == employee.getId())
			{
				listModified = true;
				index = EMPLOYEE_LIST.indexOf(listEmployee);
				break;
			}
		}
		if(listModified) {
			EMPLOYEE_LIST.set(index, employee);
		}
		else {
			throw new EmployeeNotFoundException();
		}
		
	}

	@Override
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		boolean listModified = false;
		int index = -1;
		for(Employee listEmployee: EMPLOYEE_LIST) {
			if(listEmployee.getId() == id)
			{
				listModified = true;
				index = EMPLOYEE_LIST.indexOf(listEmployee);
				break;
			}
		}
		if(listModified) {
			EMPLOYEE_LIST.remove(index);
		}
		else {
			throw new EmployeeNotFoundException();
		}
		
	}
}
