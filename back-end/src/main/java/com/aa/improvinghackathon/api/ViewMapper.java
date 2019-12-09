package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.domain.Itinerary;

import java.util.List;
import java.util.stream.Collectors;

public class ViewMapper {

    public List<ItineraryView> mapItinerary(List<Itinerary> itineraries) {
        return itineraries.stream()
                .map(itinerary -> new ItineraryView(itinerary))
                .collect(Collectors.toList());
    }

}
