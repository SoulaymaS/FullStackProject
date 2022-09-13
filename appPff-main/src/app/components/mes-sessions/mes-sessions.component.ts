import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SessionServiceService } from 'src/app/services/session-service.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-mes-sessions',
  templateUrl: './mes-sessions.component.html',
  styleUrls: ['./mes-sessions.component.css']
})
export class MesSessionsComponent implements OnInit {
  myListOfSessions
  currentUser
  SessionList
  
  constructor(private tokenStorage:TokenStorageService ,private route: ActivatedRoute, private SessServ: SessionServiceService) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorage.getUser();
    console.log(this.currentUser);

    this.SessServ.getSessions().subscribe({
      next: (response) => {
        this.SessionList= response;
        console.log(this.SessionList);
        this.SessionList.forEach(e=>e.formateur.forEach(u=>{if (u.id==this.currentUser.id) 
        this.myListOfSessions.push(e)} 
         ))
         console.log(this.myListOfSessions);
      },
      error: (err) => {
        console.log('Probleme avec getsession my session list' );
      },
    });
    };



 }


