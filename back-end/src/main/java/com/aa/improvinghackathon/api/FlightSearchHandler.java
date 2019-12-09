package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.domain.Itinerary;
import com.aa.improvinghackathon.infrastructure.service.flights.FlightEngineClient;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightSearchHandler {

    private final FlightEngineClient flightEngineClient;

    public FlightSearchHandler(final FlightEngineClient flightEngineClient) {
        this.flightEngineClient = flightEngineClient;
    }

    public List<ItineraryView> flightSearch(final FlightSearch flightSearch) {
        return retrieveFlights(flightSearch).stream()
                .map(this::mapView)
                .collect(Collectors.toList());
    }

    public List<Itinerary> retrieveFlights(final FlightSearch flightSearch) {
        return flightEngineClient.retrieveFlights(flightSearch.getDate(), flightSearch.getOrigin())
                .stream()
                .map(flight -> new Itinerary(Arrays.asList(flight)))
                .collect(Collectors.toList());
    }

    private ItineraryView mapView(final Itinerary itinerary) {
        return new ItineraryView(itinerary);
    }

}
