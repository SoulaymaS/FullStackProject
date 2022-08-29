import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFormationComponent } from './components/add-formation/add-formation.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { AdminDashComponent } from './components/admin-dash/admin-dash.component';
import { ThemeListComponent } from './components/theme-list/theme-list.component';
import { FormationListComponent } from './components/formation-list/formation-list.component';
import { AddThemeComponent } from './components/add-theme/add-theme.component';
import { AddSessionComponent } from './components/add-session/add-session.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AddStaffComponent } from './components/add-staff/add-staff.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { UpdateThemeComponent } from './components/update-theme/update-theme.component';
import { UpdateSessionComponent } from './components/update-session/update-session.component';
import { UpdateFormationComponent } from './components/update-formation/update-formation.component';
import { UpdateUserComponent } from './components/update-user/update-user.component';




const routes: Routes = [
  {path:'', redirectTo: 'acceuil', pathMatch: 'full'},
  {path:'acceuil' , component:AcceuilComponent},
  {path:'themes' , component:ThemeListComponent},
  {path:'formations', component:FormationListComponent},
  {path:'signup', component:SignUpComponent},
  {path:'signin', component:SignInComponent},
  {path: 'adminPage', component: DashboardComponent, 
   children:[
  {path:'addFormation', component:AddFormationComponent},
  {path:'addTheme', component:AddThemeComponent},
  {path:'addSession',component:AddSessionComponent },
  {path:'gestEquipe',component:AddStaffComponent},
  {path:'updateTheme/:id',component:UpdateThemeComponent},
  {path:'updateSession/:id',component:UpdateSessionComponent},
  {path:'updateFormation/:id',component:UpdateFormationComponent},
  {path:'updateSession/:id',component:UpdateUserComponent}
 
 ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
