import { Flight } from './flight';

export class Itinerary {
    id: string;
    flights: Flight[];

    constructor(itinerary: Itinerary){
        this.id = itinerary.id;
        this.flights = itinerary.flights;
    }
}