import { Component, OnInit, SimpleChanges } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { FlightsService } from 'src/app/service';
import { Flight, Itinerary } from 'src/app/model.ts';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  itineraries: Itinerary[];
  form: FormGroup;
  flightArray: Flight[];
  
  constructor(private fbuilder: FormBuilder,
    private flightsService: FlightsService) { }
  
  ngOnInit() {
    this.form = this.fbuilder.group({
      origin: 'DFW',
      destination: 'LAX',
      date: '2020-01-01'
    });

  }

  
  calculate() {
    
    let formObj = this.form.getRawValue();
  
    let serializedForm = JSON.stringify(formObj);
  
    this.flightsService.search(serializedForm)
      .then(itineraries => this.itineraries = itineraries);
  }
}
