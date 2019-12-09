import { NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import * as components from './components';

const routes: Routes = [
    {path: 'home', component: components.HomeComponent},
    {path: 'checkout', component: components.CheckoutComponent},
    {path: 'profile', component: components.ProfileComponent},
    {path:'', redirectTo: 'home', pathMatch: 'full'}
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FlightsRoutingModule { }
