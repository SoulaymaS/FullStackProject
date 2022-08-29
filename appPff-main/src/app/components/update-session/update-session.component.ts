import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Session } from 'src/app/models/Session';
import { FormationService } from 'src/app/services/formation.service';
import { SessionServiceService } from 'src/app/services/session-service.service';

@Component({
  selector: 'app-update-session',
  templateUrl: './update-session.component.html',
  styleUrls: ['./update-session.component.css']
})
export class UpdateSessionComponent implements OnInit {
  listFormation
  mySession
  constructor(private FormSer:FormationService, private SessServ:SessionServiceService, private router:Router, private activatedRoute:ActivatedRoute  ) { }

  ngOnInit(): void {
    this.FormSer.getFormations().subscribe({
      next:(res)=>{
       this.listFormation=res
      },
  
    })

    this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.SessServ.getSessionById(p.get('id')).subscribe({
          next: (response) => {
            this.mySession = response;
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
  modifSession (newS){
    return this.SessServ.updateSession(newS).subscribe({
      next:(res)=>{
        console.log(res);
        this.router.navigateByUrl('/sessions');
      },
      error: (err) => {
        console.log('probleme avec modifier session')
      }

    })

}
}
