import { Component, OnInit, Output } from '@angular/core';
import { ThemeSerrviceService } from '../../services/theme-serrvice.service';

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.css']
})
export class ThemeListComponent implements OnInit {
   listoftheme=[];
   

  constructor(private ThemSer:ThemeSerrviceService) { }

  ngOnInit(): void {
    this.listoftheme=this.ThemSer.listTemes
  }

}
