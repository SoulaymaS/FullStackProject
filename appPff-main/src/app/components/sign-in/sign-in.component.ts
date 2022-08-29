import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor( private LogInServ:LoginServiceService,
    private router:Router ) { }

  ngOnInit(): void {
  }
  seConnecter(user){
      this.LogInServ.toLogin(user).subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigateByUrl('/acceuil') 
      },
      error: (err) => {
        console.log('probleme d authentification !')
      } })

   
    
  }

}
