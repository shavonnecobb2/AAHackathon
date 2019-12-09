import { Component, OnInit } from '@angular/core'; 
import { HttpClient } from '@angular/common/http';  
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit { 

  form: FormGroup;

  constructor(private fbuilder: FormBuilder, 
    private http: HttpClient) { }

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

    this.http.post("localhost:4200/api", serializedForm)
    .subscribe(
      data => console.log("success!", data), 
      error => console.error("Error: ")
    );
  }
}
