import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Theme } from '../models/theme';


@Injectable({
  providedIn: 'root'
})
export class ThemeSerrviceService {
  // listTemes=[
  //   new Theme(1,'Informatique','https://images.pexels.com/photos/1029757/pexels-photo-1029757.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
  //   new Theme(2, 'Restauration','https://images.pexels.com/photos/262978/pexels-photo-262978.jpeg?auto=compress&cs=tinysrgb&w=600'),
  //   new Theme(3, 'Beauté','https://images.pexels.com/photos/1115128/pexels-photo-1115128.jpeg?auto=compress&cs=tinysrgb&w=600'),
  // ]
    link='http://localhost:8050/formations';

    constructor(private http: HttpClient) { }
    
    addTheme(newT){
      return this.http.post(`${this.link}/add`,newT);
    }
    getThemes(){
      return this.http.get<Theme[]>(`${this.link}/`)
    }
}
