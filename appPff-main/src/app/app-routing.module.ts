import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFormationComponent } from './components/add-formation/add-formation.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { AdminDashComponent } from './components/admin-dash/admin-dash.component';
import { ThemeListComponent } from './components/theme-list/theme-list.component';
import { FormationListComponent } from './components/formation-list/formation-list.component';


const routes: Routes = [
  {path:'acceuil' , component:AcceuilComponent},
  {path:'themes' , component:ThemeListComponent},
  {path:'formations', component:FormationListComponent},
  {path: 'adminPage', component: AdminDashComponent, 
   children:[
  {path:'addFormation',outlet:'right', component:AddFormationComponent},
 
]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
