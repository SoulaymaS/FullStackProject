import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { SessionServiceService } from 'src/app/services/session-service.service';

@Component({
  selector: 'app-payement',
  templateUrl: './payement.component.html',
  styleUrls: ['./payement.component.css']
})
export class PayementComponent implements OnInit {

  constructor(private SessServ:SessionServiceService, private activatedRoute:ActivatedRoute) { }
mySession
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
  }

}
