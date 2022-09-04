import { Component, OnInit } from '@angular/core';
import { FormationService } from 'src/app/services/formation.service';


@Component({
  selector: 'app-formation-list',
  templateUrl: './formation-list.component.html',
  styleUrls: ['./formation-list.component.css']
})
export class FormationListComponent implements OnInit {
  listformation
  constructor(private FormServ:FormationService){}
  ngOnInit(): void {
    this.FormServ.getFormations().subscribe({
      next:(res)=>{
      this.listformation=res;
      console.log(res);
      }, error: (err) => {
      }
      });
  }

  }

