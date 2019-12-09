package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.domain.Flight;
import com.aa.improvinghackathon.domain.Location;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FlightView {

    private static final String CITY = "city";
    private static final String CODE = "code";
    private static final String HOURS = "hours";
    private static final String MINS = "mins";

    private final Flight flight;

    public FlightView(Flight flight) {
        this.flight = flight;
    }

    public String getFlightNumber() {
        return flight.getFlightNumber();
    }

    public Map<String, String> getOrigin() {
        return mapLocation(flight.getOrigin());
    }

    public Map<String, String> getDestination() {
        return mapLocation(flight.getDestination());
    }

    public Map<String, Integer> getDuration() {
        return mapDuration(flight.getDuration());
    }

    public String getAircraft() {
        return flight.getAircraft();
    }

    private Map<String, String> mapLocation(final Location location) {
        Map<String, String> locationDetails = new HashMap<>();
        locationDetails.put(CITY, location.getCity());
        locationDetails.put(CODE, location.getCode());
        return locationDetails;
    }

    private Map<String, Integer> mapDuration(final Duration duration) {
        Map<String, Integer> locationDetails = new HashMap<>();
        locationDetails.put(HOURS, duration.toHoursPart());
        locationDetails.put(MINS, duration.toMinutesPart());
        return locationDetails;
    }

}
