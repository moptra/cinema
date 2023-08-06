import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ScreeningFormComponent} from "./component/screening-form/screening-form.component";
import {ScreeningListComponent} from "./component/screening-list/screening-list.component";
import {ReservationFormComponent} from "./component/reservation-form/reservation-form.component";
import {ReservationListComponent} from "./component/reservation-list/reservation-list.component";
import {MovieSummaryListComponent} from "./component/movie-summary-list/movie-summary-list.component";

const routes: Routes = [
  {path: 'screening-form', component: ScreeningFormComponent},
  {path: 'screening-list', component: ScreeningListComponent},
  {path: 'reservation-form', component: ReservationFormComponent},
  {path: 'reservation-list', component: ReservationListComponent},
  {path: 'movie-summary-list', component: MovieSummaryListComponent},
  {path: '**', component: ScreeningFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
