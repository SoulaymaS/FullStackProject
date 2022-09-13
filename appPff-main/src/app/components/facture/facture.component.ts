import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { SessionServiceService } from 'src/app/services/session-service.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.css']
})
export class FactureComponent implements OnInit {
mySession
Total
currentUser
  constructor(private tokenStorage:TokenStorageService ,private activatedRoute:ActivatedRoute, private SessServ:SessionServiceService) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorage.getUser();
    console.log(this.currentUser);

    this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.SessServ.getSessionById(p.get('id')).subscribe({
          next: (response) => {
            this.mySession= response
            console.log(this.mySession);
            this.Total=this.mySession.heureprix*this.mySession.duration
         
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
   this.Total=this.mySession.heureprix*this.mySession.duration
  }
  validate(){
    alert("Paiement validé!");
    console.log("valide");
  }
}
