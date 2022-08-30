import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormationService } from 'src/app/services/formation.service';
import { SessionServiceService } from 'src/app/services/session-service.service';

@Component({
  selector: 'app-session-list',
  templateUrl: './session-list.component.html',
  styleUrls: ['./session-list.component.css']
})
export class SessionListComponent implements OnInit {
  listofsessions
  listFormation
  constructor( private SessionServ:SessionServiceService, private router:Router) { }

  ngOnInit(): void {
        this.SessionServ.getSessions().subscribe({
      next: (res)=> {
        this.listofsessions= res;
        console.log(res);
      }, error: (err) =>{
        console.log(err);
      }
    });
  
  }


  SupprimerSession(id){
    
    if (confirm("etes vous sur de vouloir supprimer la session ?")){
    
      this.SessionServ.deleteSession(id).subscribe({
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
