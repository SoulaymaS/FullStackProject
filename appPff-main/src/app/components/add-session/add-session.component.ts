import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { Formation } from 'src/app/models/formation';
import { FormationService } from 'src/app/services/formation.service';
import { SessionServiceService } from 'src/app/services/session-service.service';

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {
listFormation:Formation[]
show=false
  constructor(private FormSer: FormationService,
    private SessServ:SessionServiceService,
    private router:Router,
    ) { }

  ngOnInit(): void {
    this.FormSer.getFormations().subscribe({
      next:(res)=>{
       this.listFormation=res
      },

    })
  }
  addSession (newS){
    console.log(newS);
    this.SessServ.addSession(newS).subscribe({
      next:(res)=>{
        console.log(res);
        this.router.navigateByUrl('/formation'); ///changer l'url à l'url de la iste des sessions une fois prete!!!!!!!
      },
      error: (err) => {
        console.log('probleme avec ajout session')
      }
    })
  
  
  
  }


}
