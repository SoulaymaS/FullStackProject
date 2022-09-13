import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { SessionServiceService } from 'src/app/services/session-service.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-payement',
  templateUrl: './payement.component.html',
  styleUrls: ['./payement.component.css']
})
export class PayementComponent implements OnInit {

  constructor(private tokenStorage:TokenStorageService ,private SessServ:SessionServiceService, private activatedRoute:ActivatedRoute, private router:Router) { }
mySession
currentUser
  ngOnInit(): void {
       this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.SessServ.getSessionById(p.get('id')).subscribe({
          next: (response) => {
            this.mySession= response
         
          },
          error: (err) => {
            console.log('Probleme avec getsessionById payement' );
          },
        });
      },
      error: (err) => {
        console.log('Probleme avec paramMap');
      },
    });
    this.tokenStorage.getUser().subscribe({
      next: (response) => {
        this.currentUser= response
     
      },
      error: (err) => {
        console.log('Probleme avec get current User' );
      },

    })
  }

  AddUserToSession(idcurrentUser:any){ 
    console.log(idcurrentUser);
    
    // this.mySession.users.push(currentUser.id)
    // this.SessServ.updateSession(this.mySession).subscribe({
    //   next: (response) => {
    //     alert("l'inscription a été effectué avec succès")
    //     // this.router.navigateByUrl((`/mesSessions/${currentUser.id}`))
    //     console.log(this.mySession);
        
     
    //   },
    //   error: (err) => {
    //     console.log('Probleme avec AddUserToSession' );
    //   }, 

    // })
}

}
