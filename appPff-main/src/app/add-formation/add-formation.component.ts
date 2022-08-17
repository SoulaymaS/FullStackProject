import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormationService } from './../services/formation.service';

@Component({
  selector: 'app-add-formation',
  templateUrl: './add-formation.component.html',
  styleUrls: ['./add-formation.component.css']
})
export class AddFormationComponent implements OnInit {

  constructor(private formServ : FormationService, private router : Router) { }

  ngOnInit(): void {
  }
 addFormation(newF){
  this.formServ.addFormation(newF).subscribe({
    next:(res)=>{
      console.log(res);
      this.router.navigateByUrl('/formations');
    },
    error: (err) => {
      console.log('probleme avec ajout formation')
    }
  });
 }
}
