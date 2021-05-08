package com.cognizant.hqlqueryinglearn;

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

import com.cognizant.hqlqueryinglearn.model.Employee;
import com.cognizant.hqlqueryinglearn.service.DepartmentService;
import com.cognizant.hqlqueryinglearn.service.EmployeeService;

@SpringBootApplication
public class HqlQueryingLearnApplication {

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static final Logger LOGGER = LoggerFactory.getLogger(HqlQueryingLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext ctx = SpringApplication.run(HqlQueryingLearnApplication.class, args);
		employeeService = ctx.getBean(EmployeeService.class);
		departmentService = ctx.getBean(DepartmentService.class);
		/**This method shouldn't be run as is, 
		 * since querying is done lazily while 
		 * this method expects eager results. 
		 * This is just to show that employee 
		 * table has data added to it via JPA, 
		 * and only after that is the permanent 
		 * employees method called.
		 */
		//testAddEmployee(); 
		testFilterEmployee();
		testNativeQuery();
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
	
	private static void testFilterEmployee() {
		LOGGER.info("Start of filter test");
		LOGGER.debug(employeeService.getAverageSalary(2)+"");
		LOGGER.info("End of filter test");
	}

	private static void testNativeQuery() {
		LOGGER.info("Start of native test");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		for(Employee employee : employees)
		{
			LOGGER.debug("Employee:{}",employee);
		}
		LOGGER.info("End of native test");
	}
}