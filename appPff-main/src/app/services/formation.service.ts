import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Formation } from '../models/Formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {
  link='http://localhost:8050/formations';
  constructor(private http: HttpClient) { }
  addFormation(newF){
    return this.http.post(`${this.link}/add`,newF);
  }
  getFormations(){
    return this.http.get<Formation[]>(`${this.link}/`)
  }
}
