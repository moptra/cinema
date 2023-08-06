import { Component } from '@angular/core';
import {ReservationListItemModel} from "../../model/out/reservation-list-item-model";
import {ReservationService} from "../../service/reservation.service";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent {
  reservations: ReservationListItemModel[] = [];

  constructor(private reservationService: ReservationService) {
    this.listAllReservations();
  }

  listAllReservations() {
    this.reservationService.listAllReservations().subscribe({
      next: data => this.reservations = data,
      error: err => console.log(err),
      complete: () => {},
    });
  }

  formatDate(date: string) {
    return new Date(date).toLocaleDateString();
  }

  formatTime(date: string) {
    return new Date(date).toLocaleTimeString();
  }

}
