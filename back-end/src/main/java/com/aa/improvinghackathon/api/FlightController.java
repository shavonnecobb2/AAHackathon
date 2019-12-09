package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.domain.Itinerary;
import com.aa.improvinghackathon.infrastructure.service.flights.response.Flight;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final ViewMapper viewMapper = new ViewMapper();

    private FlightSearchHandler flightSearchHandler;

    public FlightController(final FlightSearchHandler flightSearchHandler) {
        this.flightSearchHandler = flightSearchHandler;
    }

    @PostMapping("/search")
    public List<ItineraryView> search(@RequestBody final FlightSearch flightSearch, HttpSession httpSession) {
        List<Itinerary> itineraries = flightSearchHandler.flightSearch(flightSearch);
        httpSession.setAttribute("itineraries", itineraries);
        return viewMapper.mapItinerary(itineraries);
    }

    @PostMapping("/book")
    public Object book() {

        return new Object();
    }

    @PostMapping("/retrieve")
    public Object retrieve() {

        return new Object();
    }


}
