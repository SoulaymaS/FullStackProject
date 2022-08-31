import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ThemeSerrviceService } from '../../services/theme-serrvice.service';

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.css']
})
export class ThemeListComponent implements OnInit {
   listoftheme=[];
   
  constructor(private ThemSer:ThemeSerrviceService, private router:Router) { }

  ngOnInit(): void {
   this.ThemSer.getThemes().subscribe({
    next:(res)=>{
    this.listoftheme=res;
    console.log(res);
    }, error: (err) => {
      console.log(err);
    }
    });
  }
}
