import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ScreeningCommandModel} from "../model/screening-command-model";


const BASE_URL = "http://localhost:8080/api/screenings";
@Injectable({
  providedIn: 'root'
})
export class ScreeningService {

  constructor(private http: HttpClient) { }

  addScreening(data: ScreeningCommandModel) : Observable<any>{
    return this.http.post(BASE_URL, data);
  }
}