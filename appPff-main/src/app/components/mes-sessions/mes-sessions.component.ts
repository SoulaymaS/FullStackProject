import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SessionServiceService } from 'src/app/services/session-service.service';

@Component({
  selector: 'app-mes-sessions',
  templateUrl: './mes-sessions.component.html',
  styleUrls: ['./mes-sessions.component.css']
})
export class MesSessionsComponent implements OnInit {
  listSessions
  mySessions
  constructor(private route: ActivatedRoute, private SessServ: SessionServiceService) { }

  ngOnInit(): void {

    this.SessServ.getSessions().subscribe({
      next: (res) => {
        this.listSessions = res;
        console.log(res);


      }, error: (err) => {
        console.log(err);
      }
    });

    this.listSessions.forEach(s => {
      s.user.forEach(e => {
        if (e.id == this.route.snapshot.paramMap.get('id')) {
          this.mySessions+=s
        }
      });

    });
    console.log(this.mySessions);

  }

}
