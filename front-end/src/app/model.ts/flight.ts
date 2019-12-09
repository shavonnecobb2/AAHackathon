import { Origin } from './origin';
import { Destination } from './destination';
import { Duration } from './duration';

export class Flight {
    flightNum: string;
    origin: Origin;
    destination: Destination;
    duration: Duration;
    aircraftModel: string;

    constructor(flight: Flight){
        this.flightNum = flight.flightNum;
        this.origin = flight.origin;
        this.destination = flight.destination;
        this.duration = flight.duration;
        this.aircraftModel = flight.aircraftModel;
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 5ef5d69b1e04dffba14119bd98866a4baa5bdd7c
