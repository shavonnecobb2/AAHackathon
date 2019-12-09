import { NgModule, ComponentFactoryResolver, ANALYZE_FOR_ENTRY_COMPONENTS } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ProfileComponent } from './components/profile/profile.component';


const routes: Routes = [
    {path:'', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'checkout', component: CheckoutComponent},
    {path: 'profile', component: ProfileComponent}
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }