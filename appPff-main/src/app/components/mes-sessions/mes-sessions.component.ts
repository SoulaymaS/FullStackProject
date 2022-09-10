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
    this.tokenStorage.getUser().subscribe({
      next: (response) => {
        this.currentUser= response
     
      },
      error: (err) => {
        console.log('Probleme avec get current User' );
      },

    })

    this.SessServ.getSessions().subscribe({
      next: (response) => {
        this.SessionList= response
        this.SessionList.forEach(e=>e.users.forEach(u=>{if (u.id==this.currentUser.id) 
        this.myListOfSessions.push(e)} 
          
          ))
     
      },
      error: (err) => {
        console.log('Probleme avec getsession my session list' );
      },
    });
    };



 }


