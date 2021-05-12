package com.cognizant.springrestlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrestlearn.model.Employee;
import com.cognizant.springrestlearn.service.EmployeeService;
import com.cognizant.springrestlearn.service.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PutMapping
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException{
		employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(id);
	}
}
