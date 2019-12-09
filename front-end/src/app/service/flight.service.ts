import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Flight } from '../model.ts';


@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  constructor(private httpClient: HttpClient) { }

  //searchParams input is string of a JSON object
  search(searchParams: string): Promise<Flight[]> {
    return this.httpClient.post<Flight[]>("localhost:4200/flights/search", searchParams)
      .toPromise()
      .then(flights => (flights || []).map(flight => new Flight(flight)));
  } 

  confirm(flightId: number): Promise<Flight> { 
    return this.httpClient.get<Flight>(`localhost:4200/flights/confirm/${flightId}`)
  .toPromise()
  .then(flight => new Flight(flight)); }

//   create(account: Account): Promise<Account> {
//     return this.httpClient.post<IAccount>(`${this.baseUrl}/directory/accounts`, account)
//       .toPromise()
//       .then(response => new Account(response));
//   }

}