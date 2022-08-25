import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  regArry:any={}
  constructor(private UserServ: UserServiceService,
    private router: Router) { }

  ngOnInit(): void {
  } 
  passwordPtn ='^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,16}$'
 
  
  addUser(newU) {
    // this.UserServ.addUser(newU).subscribe({
    //   next: (res) => {
    //     console.log(res);
    //     this.router.navigateByUrl('/acceuil') 
    //   },
    //   error: (err) => {
    //     console.log('probleme avec ajout user')
    //   } })
    console.log(newU);

  }
}
