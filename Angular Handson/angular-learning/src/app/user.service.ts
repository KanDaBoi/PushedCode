import { Injectable } from '@angular/core';
import { HttpClient,HttpParams,HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, map, tap, filter } from 'rxjs/operators';
import { User } from './User'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {
  }
  getAllUsers() {
    
    //console.log(this.http.get("https://reqres.in/api/users?page=2").pipe(map( response => { return response;} )));
    return this.http.get<User[]>("https://reqres.in/api/users?page=2");
  }
  addAUser(user: User) {
    return this.http.post<User>("https://reqres.in/api/users?page=2",user);
  }

  deleteUser(id: number) {
    return this.http.delete("https://reqres.in/api/users?page=2&id=${id}");
  }
  updateUser(user: User) {
    return this.http.put<User>("https://reqres.in/api/users?page=2&id=${user.id}",user);
  }

  register(user:User) {
    return this.http.post("https://reqres.in/api/register", user).pipe(catchError((error:HttpErrorResponse) => {
      console.log(error.error);
      return throwError("Error checking successful");}));
  }
}
