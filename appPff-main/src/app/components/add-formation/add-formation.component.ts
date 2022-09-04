import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Formation } from 'src/app/models/formation';
import { Theme } from 'src/app/models/theme';
import { User } from 'src/app/models/User';
import { ThemeSerrviceService } from 'src/app/services/theme-serrvice.service';
import { FormationService } from './../../services/formation.service';
import { FormateurServiceService } from 'src/app/services/formateur-service.service';

@Component({
  selector: 'app-add-formation',
  templateUrl: './add-formation.component.html',
  styleUrls: ['./add-formation.component.css']
})
export class AddFormationComponent implements OnInit {

  constructor(private formServ: FormationService, private router: Router, private ThemeServ: ThemeSerrviceService, private FormateurServ: FormateurServiceService) { }
  show = false
  listTheme
  listFormateur
  listofFormation

  ngOnInit(): void {
    this.ThemeServ.getThemes().subscribe({
      next: (res) => {
        this.listTheme = res
      },

    }),

    this.FormateurServ.getFormateurs().subscribe({
      next: (res) => {
        this.listFormateur = res // il faut ajouter un filtre sur les user avec role formateur !!!!
        console.log(res)
      },
    }),
   
     this.formServ.getFormations().subscribe({
      next: (res) => {
        this.listofFormation = res;
        console.log(res);
      },
    })

  }

  addFormation(newF) {
    console.log(newF);
    this.formServ.addFormation(newF).subscribe({
      next: (res) => {
        console.log(res);
        this.router.navigateByUrl('/formations');
      },
      error: (err) => {
        console.log('probleme avec ajout formation')
      }
    });
  }

  SupprimerFormation(id) {

    if (confirm("etes vous sur de vouloir supprimer la formation ?")) {

      this.formServ.deleteFormation(id).subscribe({
        next: (res) => {
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
