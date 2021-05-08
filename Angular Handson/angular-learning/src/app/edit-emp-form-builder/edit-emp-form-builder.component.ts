import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup,Validators,FormBuilder,FormArray } from '@angular/forms';
import { Employee } from '../Employee';
import { Department } from '../Department';
import { Skill } from '../Skill'

@Component({
  selector: 'app-edit-emp-form-builder',
  templateUrl: './edit-emp-form-builder.component.html',
  styleUrls: ['./edit-emp-form-builder.component.css']
})
export class EditEmpFormBuilderComponent implements OnInit {

    departments:Department[] = [
      { id: 1, name: "Payroll" },
      { id: 2, name: "Internal" },
      { id: 3, name: "HR" }
    ];
    employee:Employee = {id: 3,name: "John",salary: 10000, permanent: true, department: {id: 1,name: "Payroll"},skills: [{id:1,name:"C"},{id:2,name:"Java"},{id:3,name:"Python"}], dateOfBirth: new Date("12/31/2000")};
    empForm:FormGroup = this.fb.group({
   'name': this.fb.control(this.employee.name, [
    Validators.required,
    Validators.minLength(4),
    Validators.maxLength(20)]),
    'department': this.fb.control(this.departments[0]),
    'salary': this.fb.control(this.employee.salary),
    'permanent': this.fb.control(this.employee.permanent),
    'skills': this.fb.array([])
  });
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }
  
  get name() { return this.empForm.get('name'); }
  get skills() { return this.empForm.get('skills') as FormArray; }
  get errors() {
     const name = this.empForm.get('name');
    if(name !== null)
      return name.errors;
    else
      return;
  }
  get department() {
  const department = this.empForm.get('department');
  console.log(department);
  if(department !== null)
    return this.empForm.get('department');
  else
    return;
  }
  get salary() { return this.empForm.get('salary'); }
  get permanent() { return this.empForm.get('permanent'); }
  addSkill() {
    this.skills.push(this.fb.control(''));
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
