import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Theme } from '../models/theme';


@Injectable({
  providedIn: 'root'
})
export class ThemeSerrviceService {
    link='http://localhost:8050/themes';

    constructor(private http: HttpClient) { }
    
    addTheme(newT){
      return this.http.post(`${this.link}/add`,newT);
    }
    getThemes(){
      return this.http.get<Theme[]>(`${this.link}/`)
    }
}
