import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormationService } from './../../services/formation.service';


@Component({
  selector: 'app-formation-list',
  templateUrl: './formation-list.component.html',
  styleUrls: ['./formation-list.component.css']
})
export class FormationListComponent implements OnInit {
  listofFormation;
  constructor(private formServ: FormationService, private router:Router){}
  ngOnInit(): void {
    this.formServ.getFormations().subscribe({
      next: (res)=> {
        this.listofFormation= res;
        console.log(res);
      }, error: (err) =>{
        console.log(err);
      }
    });
  }
  SupprimerFormation(id){
    
      if (confirm("etes vous sur de vouloir supprimer la formation ?")){
      
        this.formServ.deleteFormation(id).subscribe({
          next:(res)=>{
            console.log(res);
            this.router.navigateByUrl('/formations');
          },
          error: (err) => {
            console.log('probleme avec supprimer formation')
          }
    
        })
  

      }
    }
  }

