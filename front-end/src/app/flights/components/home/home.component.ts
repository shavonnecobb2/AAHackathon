import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { FlightsService } from 'src/app/service';
import { Flight } from 'src/app/model.ts';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  flights: Flight[];
  form: FormGroup;
  
  constructor(private fbuilder: FormBuilder,
    private flightsService: FlightsService) { }
  
  ngOnInit() {
    this.form = this.fbuilder.group({
      origin: '',
      destination: '',
      date: ''
    });
  
  }
  
  sendToAPI() {
    let formObj = this.form.getRawValue();
  
    let serializedForm = JSON.stringify(formObj);
  
    this.flightsService.search(serializedForm)
      .then(flights => this.flights = flights);
  }
}
