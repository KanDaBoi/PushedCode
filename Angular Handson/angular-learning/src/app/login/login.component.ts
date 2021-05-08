import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string = "";
  password: string = "";
  constructor(private router: Router,private authService: AuthService) { }

  login(): void {
    if (this.username.localeCompare('admin')==0 && this.password.localeCompare('password')==0){
      this.authService.login();
      this.router.navigateByUrl('/edit-emp-reactive');
      }
    else
      console.log('Invalid Username/Password');
  }

  ngOnInit(): void {
  }

}
