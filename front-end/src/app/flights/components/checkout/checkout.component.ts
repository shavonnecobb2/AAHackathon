import { Component, OnInit, Input } from '@angular/core'; 
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { FlightsService } from 'src/app/service';
import { Flight } from 'src/app/model.ts'; 

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  
@Input() flightId;

  flight: Flight;  
  checkoutForm: FormGroup; 
  firstName: string; 
  lastName: string; 
  email: string; 
  
  constructor(private fBuilder: FormBuilder,
    private flightService : FlightsService) { }

  ngOnInit() {  
    this.flightService.confirm(this.flightId).then(flight => {
      this.flight = flight;
    }) 
    .catch(error => {

    });
    
    this.checkoutForm = this.fBuilder.group({
      firstName: '',
      lastName: '', 
      email: ''
    }); 
    
  } 

  save() {
    // const value = this.checkoutForm.value;

    // this.checkoutForm.firstname = value.firstName; 
    // this.checkoutForm.lastName = value.lastName;
    // this.checkoutForm.email = value.email;

    // this.onSave.emit(this.checkoutForm);
  } 



}
