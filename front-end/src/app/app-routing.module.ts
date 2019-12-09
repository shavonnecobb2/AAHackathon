import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [{ 
  path: 'flights', loadChildren: () => import('./flights/flights.module').then(data => data.FlightsModule)
}, 
  { path: '', redirectTo: 'flights', pathMatch: 'full' }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
