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
  toLogOut(){

  }
 isLogedIn(){

 }


  
}
