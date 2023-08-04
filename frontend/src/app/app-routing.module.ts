import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ScreeningFormComponent} from "./component/screening-form/screening-form.component";

const routes: Routes = [
  {path: 'screening-form', component: ScreeningFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
