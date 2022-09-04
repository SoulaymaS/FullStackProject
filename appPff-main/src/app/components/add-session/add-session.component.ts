import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { Formation } from 'src/app/models/formation';
import { Session } from 'src/app/models/Session';
import { FormationService } from 'src/app/services/formation.service';
import { SessionServiceService } from 'src/app/services/session-service.service';

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {
listFormation:Formation[]
listofsessions:Session[]
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

    this.SessServ.getSessions().subscribe({
      next: (res)=> {
        this.listofsessions= res;
        console.log(res);
      }, error: (err) =>{
        console.log(err);
      }
    });
    
  }
  addSession (newS){
    console.log(newS);
    this.SessServ.addSession(newS).subscribe({
      next:(res)=>{
        console.log(res);
        this.router.navigateByUrl('/formations'); ///changer l'url à l'url de la iste des sessions une fois prete!!!!!!!
      },
      error: (err) => {
        console.log('probleme avec ajout session')
      }
    })
 
  
  
  }
  SupprimerSession(id){
    
    if (confirm("etes vous sur de vouloir supprimer la session ?")){
    
      this.SessServ.deleteSession(id).subscribe({
        next:(res)=>{
          console.log(res);
          this.router.navigateByUrl('/sessions');
        },
        error: (err) => {
          console.log('probleme avec supprimer session')
        }
  
      })


    }
  }

}
