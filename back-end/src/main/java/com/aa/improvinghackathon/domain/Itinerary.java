package com.aa.improvinghackathon.domain;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class Itinerary {

    private final String id = UUID.randomUUID().toString();
    private final List<Flight> flights;

    public Itinerary(List<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String getId() {
        return id;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public Duration getDuration() {
        Duration duration = Duration.ZERO;
        flights.stream().forEach(flight -> duration.plus(flight.getDuration()));
        return duration;
    }

}
