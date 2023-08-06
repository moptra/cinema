import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { ScreeningFormComponent } from './component/screening-form/screening-form.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { ScreeningListComponent } from './component/screening-list/screening-list.component';
import { ReservationFormComponent } from './component/reservation-form/reservation-form.component';
import { ReservationListComponent } from './component/reservation-list/reservation-list.component';
import { MovieSummaryListComponent } from './component/movie-summary-list/movie-summary-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ScreeningFormComponent,
    ScreeningListComponent,
    ReservationFormComponent,
    ReservationListComponent,
    MovieSummaryListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
