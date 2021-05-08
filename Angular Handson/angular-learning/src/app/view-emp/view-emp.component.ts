import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee'
@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {
  employee: Employee = {id: 3,name: "John",salary: 10000, permanent: true, department: {id: 1,name: 'CSE'},skills: [{id:1,name:"C"},{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("12/31/2000")};
  constructor() { }

  ngOnInit(): void {
  }

}
