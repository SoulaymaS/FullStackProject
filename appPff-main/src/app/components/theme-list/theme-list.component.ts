import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ThemeSerrviceService } from '../../services/theme-serrvice.service';

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.css']
})
export class ThemeListComponent implements OnInit {
   listoftheme=["1","2","3"];
   

  constructor(private ThemSer:ThemeSerrviceService, private router:Router
    ) { }

  ngOnInit(): void {
  //  this.ThemSer.getThemes().subscribe({

  //   next:(res)=>{
  //   this.listoftheme=res
     
  //   }

  //   })
  }
  supprimerTheme(id){
    if (confirm("etes vous sur de vouloir supprimer le thème ?")){
      
      this.ThemSer.deleteTheme(id).subscribe({
        next:(res)=>{
          console.log(res);
          this.router.navigateByUrl('/themes');
        },
        error: (err) => {
          console.log('probleme avec supprimer theme')
        }
  
      })
    }

  


  }

}
