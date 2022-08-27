import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { ThemeListComponent } from './components/theme-list/theme-list.component';
import { CardComponent } from './components/card/card.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { HttpClientModule } from '@angular/common/http';
import { FormationListComponent } from './components/formation-list/formation-list.component';
import { AddFormationComponent } from './components/add-formation/add-formation.component';
import { FormsModule } from '@angular/forms';
import { AdminDashComponent } from './components/admin-dash/admin-dash.component';
import { AddThemeComponent } from './components/add-theme/add-theme.component';
import { AddSessionComponent } from './components/add-session/add-session.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { FooterComponent } from './components/footer/footer.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AddStaffComponent } from './components/add-staff/add-staff.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ProfileComponent } from './components/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    AcceuilComponent,
    ThemeListComponent,
    CardComponent,
    NavbarComponent,
    CarouselComponent,
    FormationListComponent,
    AddFormationComponent,
    AdminDashComponent,
    AddThemeComponent,
    AddSessionComponent,
    SignUpComponent,
    FooterComponent,
    DashboardComponent,
    AddStaffComponent,
    SignInComponent,
    ProfileComponent,
 
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
