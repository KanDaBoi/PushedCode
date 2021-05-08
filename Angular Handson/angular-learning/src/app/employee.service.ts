import { Injectable } from '@angular/core';
import { Employee } from './Employee'

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employeeList:Employee[] = [
    {id: 1,name: "John",salary: 10000, permanent: false, department: {id: 1,name: "Payroll"},skills: [{id:1,name:"C"},{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("01/31/2000")},
    {id: 2,name: "Smith",salary: 50000, permanent: true, department: {id: 2,name: "Internal"},skills: [{id:3,name:"Python"}], dateOfBirth: new Date("02/20/2000")},
    {id: 3,name: "Mary",salary: 35000, permanent: true, department: {id: 3,name: "HR"},skills: [{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("01/16/2000")},
    {id: 4,name: "David",salary: 50000, permanent: true, department: {id: 2,name: "Internal"},skills: [{id:1,name:"C"},{id:3,name:"Python"}], dateOfBirth: new Date("01/29/2000")},
    {id: 5,name: "Reece",salary: 10000, permanent: false, department: {id: 1,name: "Payroll"},skills: [{id:1,name:"C"}], dateOfBirth: new Date("01/31/2000")}
  ];
  constructor() { }
  getAllEmployees(): Employee[] { return this.employeeList; }
  getEmployee(employeeId: number): Employee {
    return this.employeeList.filter(employee => {return employee.id === employeeId;})[0];
  }
}
