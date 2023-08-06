import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ReservationCommandModel} from "../model/in/reservation-command-model";
import {Observable} from "rxjs";
import {ReservationListItemModel} from "../model/out/reservation-list-item-model";

const BASE_URL = "http://localhost:8080/api/reservations";
@Injectable({
  providedIn: 'root'
})

export class ReservationService {

  constructor(private http: HttpClient) { }

  addReservation(data: ReservationCommandModel): Observable<any> {
    return this.http.post(BASE_URL, data);
  }

  listAllReservations(): Observable<ReservationListItemModel[]> {
    return this.http.get<ReservationListItemModel[]>(BASE_URL);
  }

}
