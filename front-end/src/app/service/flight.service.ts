import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Flight, Itinerary } from '../model.ts';


@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  constructor(private httpClient: HttpClient) { }

  //searchParams input is string of a JSON object
  search(searchParams: string): Promise<Itinerary[]> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');

    return this.httpClient.post<Itinerary[]>("http://localhost:8080/flights/search", searchParams, {headers: headers})
      .toPromise()
<<<<<<< HEAD
      .then(flights => (flights || []).map(flight => new Flight(flight)));
  } 

  confirm(flightId: number): Promise<Flight> { 
    return this.httpClient.get<Flight>(`localhost:4200/flights/confirm/${flightId}`)
  .toPromise()
  .then(flight => new Flight(flight)); }
=======
      .then(i => (i || []).map(i => new Itinerary(i)));
  }
>>>>>>> 347715b119de935ce458dcda5968b62de0be41c9

//   create(account: Account): Promise<Account> {
//     return this.httpClient.post<IAccount>(`${this.baseUrl}/directory/accounts`, account)
//       .toPromise()
//       .then(response => new Account(response));
//   }

}