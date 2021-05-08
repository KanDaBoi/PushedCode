import { Component, OnInit } from '@angular/core';
import { Employee } from '../Employee';
import { Department } from '../Department';

@Component({
  selector: 'app-edit-emp-template-driven',
  templateUrl: './edit-emp-template-driven.component.html',
  styleUrls: ['./edit-emp-template-driven.component.css']
})
export class EditEmpTemplateDrivenComponent implements OnInit {
  departments:Department[] = [
      { id: 1, name: "Payroll" },
      { id: 2, name: "Internal" },
      { id: 3, name: "HR" }
    ];
  employee:Employee = {id: 3,name: "John",salary: 10000, permanent: true, department: {id: 1,name: "Payroll"},skills: [{id:1,name:"C"},{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("12/31/2000")};
  constructor() {}

  ngOnInit(): void {
  }

  compareFn(id1: number,id2: number): boolean {
        return id1==id2;
  }
  onSubmit(): void {
    console.log(this.employee);
  }

  changeFn(event:Event): void {
      if((event.target as HTMLInputElement).value == '1')
      {
        this.employee.department = this.departments[0];
      }
      else if((event.target as HTMLInputElement).value == '2')
      {
        this.employee.department = this.departments[1];
      }
      else if((event.target as HTMLInputElement).value == '3')
      {
        this.employee.department = this.departments[2];
      }
      
  }
}
