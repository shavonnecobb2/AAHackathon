package com.aa.improvinghackathon.domain;

import java.time.Duration;

public class Flight {

    private final String flightNumber;
    private final Location origin;
    private final Location destination;
    private final Duration duration;
    private final String aircraft;

    public Flight(String flightNumber, Location origin, Location destination, Duration duration, String aircraft) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.aircraft = aircraft;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getAircraft() {
        return aircraft;
    }

}
