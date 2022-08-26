import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor( private http:HttpClient) { }
  link="http://localhost:8050/signin"
 

  toLogin(user){
    return this.http.post(this.link, user);


  }
  toLogOut(){

  }
 isLogedIn(){

 }


  
}
