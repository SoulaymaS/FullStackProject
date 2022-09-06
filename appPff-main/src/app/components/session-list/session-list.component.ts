import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { FormationService } from 'src/app/services/formation.service';
import { SessionServiceService } from 'src/app/services/session-service.service';

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.css']
})
export class SessionListComponent implements OnInit {
 
  constructor(private FormServ: FormationService, private activatedRoute:ActivatedRoute ) { }
  listsessions
  listformations
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.FormServ.getFormationById(p.get('id')).subscribe({
          next: (response) => {
            this.listformations= response
            console.log(this.listformations);
            this.listsessions=this.listformations.sessions
          },
          error: (err) => {
            console.log('Probleme avec getFormationById');
          },
        });
      },
      error: (err) => {
        console.log('Probleme avec paramMap');
      },
    });

    


  
  }



}
