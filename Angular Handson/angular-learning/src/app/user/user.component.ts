import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service'
import { User } from '../User'
import { Observable, throwError } from 'rxjs';
import { catchError, retry, map, tap, filter } from 'rxjs/operators';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  dataObject: Object = {page: "",per_page:"",total:"",total_pages:"",data: [],support: {url:"",text:""}};
  viewStatus: boolean = false;
  addStatus: boolean = false;
  deleteStatus: boolean = false;
  updateStatus: boolean = false;
  users: User[] = [];
  constructor(private userService: UserService) { }

  ngOnInit(): void {
        //this.viewUsers();
        //this.addUser();
        //this.deleteUser();
        //this.updateUser();
  }

  viewUsers(): void {
    this.viewStatus = true;
    this.addStatus = false;
  this.deleteStatus = false;
  this.updateStatus = false;
    this.userService.getAllUsers().subscribe( (dataObject: any) => {
                        this.users = dataObject.data;
                        console.log(this.users);
                        });
  }

  addUser(): void {
    this.viewStatus = false;
    this.addStatus = true;
  this.deleteStatus = false;
  this.updateStatus = false;
    let user: User = {"id":29,"email":"reggie.couz@reqres.in","first_name":"Couz","last_name":"Reggie","avatar":"https://reqres.in/img/faces/7-image.jpg"};
    this.userService.addAUser(user).subscribe( (user: User) => {
        this.users.push(user);
    });  
  }

  deleteUser(): void {
      this.viewStatus = false;
    this.addStatus = false;
  this.deleteStatus = true;
  this.updateStatus = false;
      let id: number = 29;
      this.userService.deleteUser(id).subscribe( _ => console.log("Delete working fine"));
  }

  updateUser(): void {
      this.viewStatus = false;
    this.addStatus = false;
  this.deleteStatus = false;
  this.updateStatus = true;
      let user:User = {"id":7,"email":"babarnamrononjoy@reqres.in","first_name":"Malik","last_name":"Haqim","avatar":""};
      this.userService.updateUser(user).subscribe(_ => console.log("Put working fine"));
  }

  register(): void {
    let user: User = { id: 0, email: "", first_name: "", last_name:"",avatar:"" };
    this.userService.register(user).subscribe();
        }

}
