import { Origin } from './origin';
import { Destination } from './destination';
import { Duration } from './duration';

export class Flight {
    flightNum: string;
    origin: Origin;
    destination: Destination;
<<<<<<< HEAD
    duration: Duration;
    aircraftModel: string;

=======
    duration: Duration; 
    aircraftModel: string;
    
>>>>>>> bb0fbabea9d8a5b0fb82eb8487f4ddf7d362e50e
    constructor(flight: Flight){
        this.flightNum = flight.flightNum;
        this.origin = flight.origin;
        this.destination = flight.destination;
        this.duration = flight.duration;
        this.aircraftModel = flight.aircraftModel;
    }

}
