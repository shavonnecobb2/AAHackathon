import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import {AppRoutingModule} from './flights-routing.module';

import * as components from './components';


@NgModule({
  declarations: [
    components.HomeComponent,
    components.CheckoutComponent,
    components.ProfileComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    FormsModule
  ]
})
export class FlightsModule { }
