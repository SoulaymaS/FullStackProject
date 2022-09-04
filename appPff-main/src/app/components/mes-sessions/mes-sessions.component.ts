import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-mes-sessions',
  templateUrl: './mes-sessions.component.html',
  styleUrls: ['./mes-sessions.component.css']
})
export class MesSessionsComponent implements OnInit {
listSessions
  constructor(private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    // this.activatedRoute.paramMap.subscribe({
    //   next: (p: ParamMap) => {
    //     this.ThemServ.getThemeById(p.get('id')).subscribe({
    //       next: (res) => {
    //         this.listSessions = res;
            
    //       },
    //       error: (err) => {
    //         console.log(err);
            
    //         console.log('Probleme avec getSession');
    //       },
    //     });
    //   },
    //   error: (err) => {
    //     console.log(err);
        
    //     console.log('Probleme avec paramMap');
    //   },
    // });
  }

}
