import { Component, OnInit } from '@angular/core';
import { HostListener } from '@angular/core';
import { LoginServiceService } from './../../services/login-service.service';
import { TokenStorageService } from './../../services/token-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private token:TokenStorageService) { }

  ngOnInit(): void {
  }

toLogout(){
this.token.signOut();
}
@HostListener('window:scroll', ['$event'])

onWindowScroll() {
    let element = document.querySelector('.navbar') as HTMLElement;
    if (window.pageYOffset > element.clientHeight) {
      element.classList.add('scrollingstyle');
    } else {
      element.classList.remove('scrollingstyle');
    }
  }

}
