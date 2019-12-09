import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import * as components from './components';
import { FlightsRoutingModule } from './flights-routing.module'


import {AppRoutingModule} from './flights-routing.module';

import * as components from './components';


@NgModule({
  declarations: [
    components.CheckoutComponent,
    components.HomeComponent,
    components.ProfileComponent
  ],
  imports: [
    CommonModule,
    FlightsRoutingModule
  ]
})
export class FlightsModule { }
