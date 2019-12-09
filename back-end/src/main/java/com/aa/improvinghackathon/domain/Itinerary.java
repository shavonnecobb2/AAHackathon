package com.aa.improvinghackathon.domain;

import java.util.List;
import java.util.UUID;

public class Itinerary {

    private final String id = UUID.randomUUID().toString();
    private final List<Flight> flights;

    public Itinerary(List<Flight> flights) {
        this.flights = flights;
    }

    public String getId() {
        return id;
    }

    public List<Flight> getFlights() {
        return flights;
    }

}
