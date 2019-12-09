package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.domain.Flight;
import com.aa.improvinghackathon.domain.Itinerary;
import com.aa.improvinghackathon.infrastructure.service.flights.FlightEngineClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightSearchHandler {

    private final FlightEngineClient flightEngineClient;

    public FlightSearchHandler(final FlightEngineClient flightEngineClient) {
        this.flightEngineClient = flightEngineClient;
    }

    public List<Itinerary> flightSearch(final FlightSearch flightSearch) {
        List<Itinerary> itineraries = new ArrayList<>();

        List<Flight> allFlights = flightEngineClient.retrieveFlights(flightSearch.getDate(), flightSearch.getOrigin());
        allFlights.stream()
                .map(flight -> flight.getDestination().getCode())
                .filter(code -> !code.equals(flightSearch.getDestination()))
                .distinct()
                .forEach(code -> allFlights.addAll(flightEngineClient.retrieveFlights(flightSearch.getDate(), code)));

        // TODO: BUILD A TREE
        

        return allFlights.stream()
                .map(flight -> new Itinerary(Arrays.asList(flight)))
                .collect(Collectors.toList());
    }

}
