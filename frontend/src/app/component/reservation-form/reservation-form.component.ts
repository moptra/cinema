import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ReservationService} from "../../service/reservation.service";
import {ScreeningService} from "../../service/screening.service";
import {ScreeningListItemModel} from "../../model/out/screening-list-item-model";
import {ReservationCommandModel} from "../../model/in/reservation-command-model";
import {validationHandler} from "../../utils/validation-handler";

@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent {

  reservationForm: FormGroup;

  screenings: ScreeningListItemModel[] = [];

  movieTitle: string = '';

  uniqueScreeningTitles: string[] = [];

  constructor(private reservationService: ReservationService,
              private formBuilder: FormBuilder,
              private screeningService: ScreeningService) {
    this.reservationForm = formBuilder.group({
      name: ['', Validators.required],
      reservedSeats: [0, Validators.required],
      screeningTitle: ['', Validators.required],
      screeningDate: ['', Validators.required]
    });

    this.reservationForm.get('screeningTitle')?.valueChanges.subscribe({
      next: data => this.movieTitle = data,
    });


  }

  ngOnInit() {
    this.getAllScreening();
  }

  saveReservation() {
    const data: ReservationCommandModel = this.reservationForm.value;

    this.reservationService.addReservation(data).subscribe({
      next: data => {
      },
      error: err => {
        console.log(err);
        validationHandler(err, this.reservationForm);
      },
      complete: () => {
        console.log(data);
        this.reservationForm.reset();
      }
    });
  }

  getAllScreening() {
    this.screeningService.listAllScreening().subscribe({
      next: data => this.screenings = data,
      error: err => console.log(err),
      complete: () => {
        this.screenings.forEach((element) => {
          if (!this.uniqueScreeningTitles.includes(element.title)) {
            this.uniqueScreeningTitles.push(element.title)
          }
        });
      }
    });
  }

  formatDate(date: string) {
    return new Date(date).toLocaleDateString();
  }

  formatTime(date: string) {
    return new Date(date).toLocaleTimeString();
  }

}
