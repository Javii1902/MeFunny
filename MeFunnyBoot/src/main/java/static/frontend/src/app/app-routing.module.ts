import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav/nav.component'

const routes: Routes = [
  {
    /*
      If you wish to use a component's view for the landing page, the page should be an empty string.
    */
    path: "",
    component: HomeComponent
  },
  {
    path: "login",
    component: LoginComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
