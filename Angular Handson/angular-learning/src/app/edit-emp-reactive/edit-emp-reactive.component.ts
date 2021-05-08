import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup,Validators } from '@angular/forms';
import { Employee } from '../Employee';
import { Department } from '../Department';
import { Skill } from '../Skill'
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service'

@Component({
  selector: 'app-edit-emp-reactive',
  templateUrl: './edit-emp-reactive.component.html',
  styleUrls: ['./edit-emp-reactive.component.css']
})
export class EditEmpReactiveComponent implements OnInit {
    departments:Department[] = [];
   employee:Employee = {id:0,name:"",salary:0,permanent:false,department: {id:0,name:""},skills:[],dateOfBirth: new Date("12/31/2000")};
   empForm:FormGroup = new FormGroup({});
  get name() { return this.empForm.get('name'); }
  get errors() {
     const name = this.empForm.get('name');
    if(name !== null)
      return name.errors;
    else
      return;
  }
  get department() {
  const department = this.empForm.get('department');
  //console.log(department);
  return this.empForm.get('department') as FormControl;
  }
  get salary() { return this.empForm.get('salary'); }
  get permanent() { return this.empForm.get('permanent'); }
  constructor(private route: ActivatedRoute,private employeeService : EmployeeService) {
    this.employee = employeeService.getEmployee((this.route.snapshot.paramMap.get('id') as unknown) as number);
  }

  ngOnInit(): void {
    this.departments = [{ id: 1, name: "Payroll" },
      { id: 2, name: "Internal" },
      { id: 3, name: "HR" }
    ];
     this.employee = {id: 3,name: "John",salary: 10000, permanent: true, department: {id: 1,name: "Payroll"},skills: [{id:1,name:"C"},{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("12/31/2000")};
     this.empForm = new FormGroup({
   'name': new FormControl(this.employee.name, [
    Validators.required,
    Validators.minLength(4),
    Validators.maxLength(20)]),
    'department': new FormControl(this.departments[0]),
    'salary': new FormControl(this.employee.salary),
    'permanent': new FormControl(this.employee.permanent)
  });
     const employeeId = this.route.snapshot.paramMap.get('id');
  console.log(employeeId);
  }
  onSubmit(): void {
    this.employee.name = this.empForm.get('name')?.value;
    this.employee.salary = this.empForm.get('salary')?.value;
    this.employee.department = this.empForm.get('department')?.value;
    this.employee.permanent = this.empForm.get('permanent')?.value;
    console.log(this.employee);
    console.log(this.empForm.value);
  }

}
