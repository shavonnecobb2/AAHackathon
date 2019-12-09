package com.aa.improvinghackathon.infrastructure.service.flights;

import com.aa.improvinghackathon.domain.Itinerary;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ItineraryRepository {

    private final Map<String, Itinerary> itineraries = new HashMap<>();

    public String add(final Itinerary itinerary) {
        String recordLocator = UUID.randomUUID().toString().substring(0, 6);
        itineraries.put(recordLocator, itinerary);
        return recordLocator;
    }

    public Itinerary get(final String recordLocator) {
        return itineraries.get(recordLocator);
    }

}
