package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.domain.Flight;
import com.aa.improvinghackathon.domain.Itinerary;

import java.util.List;
import java.util.stream.Collectors;

public class ItineraryView {

    private final Itinerary itinerary;

    public ItineraryView(final Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public String getId() {
        return itinerary.getId();
    }

    public List<FlightView> getFlights() {
        return itinerary.getFlights().stream()
                .map(this::mapFlights)
                .collect(Collectors.toList());
    }

    private FlightView mapFlights(final Flight flight) {
        return new FlightView(flight);
    }

}
