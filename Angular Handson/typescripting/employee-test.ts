import {Employee} from "./employee";
import {Skill} from "./skill"
class EmployeeTest{
	employee: Employee;
	constructor(employee: Employee)
	{
		this.employee = employee;
	}
	display()
	{
		console.log("id:"+this.employee.id);
		console.log("name:" + this.employee.name);
		console.log("salary:" + this.employee.salary);
		console.log("permanent:" + this.employee.permanent);
		console.log("department id:" + this.employee.department.id);
		console.log("department name:" + this.employee.department.name);
		let iterator;
		let counter = 0;
		for(iterator of this.employee.skills)
		{
			console.log("Skill["+counter+"]:"+iterator.id+", "+iterator.name);
			counter = counter+1;
		}
	}
} 
let employee:Employee = {id: 1,name: "Kanishk Jha",salary: 25000,permanent: true, department: {id: 1,name:"CSE"},skills: [{id:1,name:"C"},{id:2,name:"Java"},{id:3,name:"Python"}]};
let employeeTest: EmployeeTest = new EmployeeTest(employee);
employeeTest.display();