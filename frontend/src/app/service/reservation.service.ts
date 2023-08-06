import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ReservationCommandModel} from "../model/in/reservation-command-model";
import {Observable} from "rxjs";

const BASE_URL = "http://localhost:8080/api/reservations";
@Injectable({
  providedIn: 'root'
})

export class ReservationService {

  constructor(private http: HttpClient) { }

  addReservation(data: ReservationCommandModel): Observable<any> {
    return this.http.post(BASE_URL, data);
  }

}
