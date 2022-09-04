import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormateurServiceService } from 'src/app/services/formateur-service.service';
import { UserServiceService } from 'src/app/services/user-service.service';

@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.css']
})
export class AddStaffComponent implements OnInit {
  regArry:any={}
  passwordPtn ='^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,16}$'
  cinPtn='[0-9]{8}'
  show=false
  listofFormateurs
  constructor(private UserServ:UserServiceService, private FormateurServ:FormateurServiceService,private router:Router) { }

  ngOnInit(): void {
    this.FormateurServ.getFormateurs().subscribe({
      next:(res)=>{
       this.listofFormateurs=res
      },

    })
  }
  addStaff(newU){
    if (newU.role=="formateur"){
          this.FormateurServ.addFormateur(newU).subscribe({
      next:(res)=>{
        console.log(res);
        // this.router.navigateByUrl('/acceuil'); 
      },
      error: (err) => {
        console.log('probleme avec ajout staff')
      } 

  })

    }
  }

  SupprimerFormateur(id){
    
    if (confirm("etes vous sur de vouloir supprimer le formateur ?")){
    
      this.FormateurServ.deleteFormateur(id).subscribe({
        next:(res)=>{
          console.log(res);
          this.router.navigateByUrl('/adminPage/gestEquipe');
        },
        error: (err) => {
          console.log('probleme avec supprimer formateur')
        }
  
      })


    }
  }
}



