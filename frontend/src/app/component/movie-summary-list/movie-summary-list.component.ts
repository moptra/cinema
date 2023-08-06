import { Component } from '@angular/core';
import {MovieSummaryListItem} from "../../model/out/movie-summary-list-item";
import {ScreeningService} from "../../service/screening.service";

@Component({
  selector: 'app-movie-summary-list',
  templateUrl: './movie-summary-list.component.html',
  styleUrls: ['./movie-summary-list.component.css']
})
export class MovieSummaryListComponent {

  movieSummaryList : MovieSummaryListItem[] = [];

  constructor(private screeningService: ScreeningService) {
    this.getMovieSummary();
  }


  getMovieSummary() {
    this.screeningService.getMovieSummary().subscribe({
      next: data => this.movieSummaryList = data,
      error: err => console.log(err),
      complete: () => {},
    });
  }


}
