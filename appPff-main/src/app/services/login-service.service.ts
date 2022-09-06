import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const AUTH_API = 'http://localhost:8050/auth/' ;

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor( private http:HttpClient) { }
  

  toLogin(user): Observable<any>{
    return this.http.post(AUTH_API + 'signin', user, httpOptions);
  }
  toRegister(user): Observable<any>{
    return this.http.post(AUTH_API + 'signup', user, httpOptions);
  }

 isLoggedIn(){
  let token =  window.sessionStorage.getItem('auth-user');
  if (token) return true;
  else return false;

 }
 tologout(){
  window.sessionStorage.removeItem('auth-user');
  localStorage.removeItem('auth-user');
  
 }


  
}
