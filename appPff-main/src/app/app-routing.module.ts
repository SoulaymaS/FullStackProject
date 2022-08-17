import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFormationComponent } from './add-formation/add-formation.component';
import { AcceuilComponent } from './components/acceuil/acceuil.component';
import { ThemeListComponent } from './components/theme-list/theme-list.component';
import { FormationListComponent } from './formation-list/formation-list.component';

const routes: Routes = [
  {path:'acceuil' , component:AcceuilComponent},
  {path:'themes' , component:ThemeListComponent},
  {path:'formations', component:FormationListComponent},
  {path:'addFormation', component:AddFormationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
