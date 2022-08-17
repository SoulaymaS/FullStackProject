import { Component, OnInit } from '@angular/core';
import { FormationService } from './../services/formation.service';

@Component({
  selector: 'app-formation-list',
  templateUrl: './formation-list.component.html',
  styleUrls: ['./formation-list.component.css']
})
export class FormationListComponent implements OnInit {
  listofFormation=[];
  constructor(private formServ: FormationService) { }

  ngOnInit(): void {
    this.formServ.getFormations().subscribe({
      next: (res)=> {
        this.listofFormation= res;
        console.log(res);
      }, error: (err) =>{
        console.log(err);
      }
    });
  }

}
