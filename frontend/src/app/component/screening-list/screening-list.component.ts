import { Component } from '@angular/core';
import {ScreeningListItemModel} from "../../model/out/screening-list-item-model";
import {ScreeningService} from "../../service/screening.service";

@Component({
  selector: 'app-screening-list',
  templateUrl: './screening-list.component.html',
  styleUrls: ['./screening-list.component.css']
})
export class ScreeningListComponent {

  screenings : ScreeningListItemModel[] = [];

  constructor(private screeningService: ScreeningService) {
  }

  ngOnInit() {
    this.listAllScreening();
  }

  listAllScreening() {
    this.screeningService.listAllScreening().subscribe({
      next: value => this.screenings = value,
      error: err => console.log(err),
      complete: () => {},
    })
  }
}
