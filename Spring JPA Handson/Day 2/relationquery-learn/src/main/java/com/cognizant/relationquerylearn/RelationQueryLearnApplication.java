package com.cognizant.relationquerylearn;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.relationquerylearn.model.Department;
import com.cognizant.relationquerylearn.model.Employee;
import com.cognizant.relationquerylearn.model.Skill;
import com.cognizant.relationquerylearn.service.DepartmentService;
import com.cognizant.relationquerylearn.service.EmployeeService;
import com.cognizant.relationquerylearn.service.SkillService;

@SpringBootApplication
public class RelationQueryLearnApplication {
	// private static CountryService countryService;

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RelationQueryLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext ctx = SpringApplication.run(RelationQueryLearnApplication.class, args);
		employeeService = ctx.getBean(EmployeeService.class);
		departmentService = ctx.getBean(DepartmentService.class);
		skillService = ctx.getBean(SkillService.class);
        testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee: {}", employee);
		LOGGER.debug("Department: {}", employee.getDepartment());
		LOGGER.debug("Skills: {}",employee.getSkillList());
		LOGGER.info("END");
	
	}

	private static void testAddEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		String dob = "1998-08-16";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		employee.setName("Kanishk Jha");
		employee.setPermanent(true);
		employee.setSalary(new BigDecimal(50000));
		employee.setDepartment(departmentService.get(3));
		try {
			Date date = df.parse(dob);
			employee.setDateOfBirth(date);
		} catch (ParseException pe) {
			System.out.println(pe.getMessage());
		}
		employeeService.save(employee);
		LOGGER.debug(employee.toString());
	}


	private static void testUpdateEmployee() {
		Employee employee = employeeService.get(1);
		Department department = departmentService.get(2);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug(employee.toString());
	}
	
	private static void testGetDepartment() {
		Department department = departmentService.get(5);
		LOGGER.debug(department.toString());
		for(Employee employee : department.getEmployeeList())
		{
			LOGGER.debug(employee.toString());
		}
	}
	
	private static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employeeService.save(employee);
		LOGGER.debug(employee.toString());
	}

}
