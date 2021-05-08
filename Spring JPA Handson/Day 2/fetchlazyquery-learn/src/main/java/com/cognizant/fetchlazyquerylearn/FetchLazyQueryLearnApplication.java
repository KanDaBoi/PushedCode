package com.cognizant.fetchlazyquerylearn;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.fetchlazyquerylearn.model.Employee;
import com.cognizant.fetchlazyquerylearn.service.DepartmentService;
import com.cognizant.fetchlazyquerylearn.service.EmployeeService;

@SpringBootApplication
public class FetchLazyQueryLearnApplication {

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static final Logger LOGGER = LoggerFactory.getLogger(FetchLazyQueryLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext ctx = SpringApplication.run(FetchLazyQueryLearnApplication.class, args);
		employeeService = ctx.getBean(EmployeeService.class);
		departmentService = ctx.getBean(DepartmentService.class);
		/**
		 * This method shouldn't be run as is, 
		 * since querying is done lazily while this method expects 
		 * eager results. This is just to show that employee table 
		 * has data added to it via JPA, and only after that is the 
		 * permanent employees method called.
		 */
		//testAddEmployee(); 
		testGetAllPermanentEmployees();
	}

	private static void testGetAllPermanentEmployees() {
		LOGGER.info("start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		String dob = "1998-08-16";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		employee.setName("Kanishk Jha");
		employee.setPermanent(true);
		employee.setSalary(new BigDecimal(10000));
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
}