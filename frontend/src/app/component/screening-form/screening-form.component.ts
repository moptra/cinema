import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ScreeningService} from "../../service/screening.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-screening-form',
  templateUrl: './screening-form.component.html',
  styleUrls: ['./screening-form.component.css']
})
export class ScreeningFormComponent {

  screeningForm: FormGroup;

  constructor(private screeningService: ScreeningService,
              private formBuilder: FormBuilder,
              private router: Router) {
    this.screeningForm = formBuilder.group({
      title: ['', Validators.required],
      screeningDate: ['', Validators.required],
      seats: ['', Validators.required],
      imageUrl: ''
    })
  }

  saveScreening() {
    const data = this.screeningForm.value;
    this.screeningService.addScreening(data).subscribe({
      next: data => {},
      error: err => console.log(err),
      complete: () => {
        this.router.navigate(['screening-list']);
      }
    });
  }

}
