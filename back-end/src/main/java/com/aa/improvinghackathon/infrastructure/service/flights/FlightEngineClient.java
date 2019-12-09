package com.aa.improvinghackathon.infrastructure.service.flights;

import com.aa.improvinghackathon.infrastructure.service.flights.response.Duration;
import com.aa.improvinghackathon.infrastructure.service.flights.response.Flight;
import com.aa.improvinghackathon.infrastructure.service.flights.response.Location;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FlightEngineClient {

    private static final String DATE = "date";
    private static final String ORIGIN = "origin";

    private final WebClient webClient;

    public FlightEngineClient() {
        this.webClient = WebClient.create("http://aa-flight-engine.herokuapp.com/flights");
    }

    public List<com.aa.improvinghackathon.domain.Flight> retrieveFlights(final String date, final String origin) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .queryParam(DATE, date)
                    .queryParam(ORIGIN, origin)
                    .build())
                .retrieve()
                .bodyToFlux(Flight.class)
                .map(this::mapFlight)
                .collectList()
                .block();
    }

    private com.aa.improvinghackathon.domain.Flight mapFlight(final Flight serviceFlight) {
        return new com.aa.improvinghackathon.domain.Flight(
                serviceFlight.getFlightNumber(),
                mapLocation(serviceFlight.getOrigin()),
                mapLocation(serviceFlight.getDestination()),
                mapDuration(serviceFlight.getDuration()),
                serviceFlight.getAircraft().getModel()
        );
    }

    private java.time.Duration mapDuration(final Duration serviceDuration) {
        return java.time.Duration.ofHours(serviceDuration.getHours()).plusMinutes(serviceDuration.getMinutes());
    }

    private com.aa.improvinghackathon.domain.Location mapLocation(final Location serviceLocation) {
        return new com.aa.improvinghackathon.domain.Location(serviceLocation.getCity(), serviceLocation.getCity());
    }

}
