import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';
import { Department } from '../Department';
import { Skill } from '../Skill'

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employeeList: Employee[] = [
    {id: 1,name: "John",salary: 10000, permanent: false, department: {id: 1,name: "Payroll"},skills: [{id:1,name:"C"},{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("01/31/2000")},
    {id: 2,name: "Smith",salary: 50000, permanent: true, department: {id: 2,name: "Internal"},skills: [{id:3,name:"Python"}], dateOfBirth: new Date("02/20/2000")},
    {id: 3,name: "Mary",salary: 35000, permanent: true, department: {id: 3,name: "HR"},skills: [{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("01/16/2000")},
    {id: 4,name: "David",salary: 50000, permanent: true, department: {id: 2,name: "Internal"},skills: [{id:1,name:"C"},{id:3,name:"Python"}], dateOfBirth: new Date("01/29/2000")},
    {id: 5,name: "Reece",salary: 10000, permanent: false, department: {id: 1,name: "Payroll"},skills: [{id:1,name:"C"}], dateOfBirth: new Date("01/31/2000")}
  ]
  filteredEmployees?: Employee[];
  searchKey: string = "";
  constructor() { }

  ngOnInit(): void {
  }
  search(): void {
    this.filteredEmployees = this.employeeList.filter( employee => { let name = employee.name.toLowerCase();
                                                                     let search = this.searchKey.toLowerCase();
                                                                     return name.includes(search) && search !== "";});
  }
}
