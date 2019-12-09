package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.infrastructure.service.flights.response.Flight;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightSearchHandler flightSearchHandler;

    public FlightController(final FlightSearchHandler flightSearchHandler) {
        this.flightSearchHandler = flightSearchHandler;
    }

    @PostMapping("/search")
    public List<ItineraryView> search(@RequestBody final FlightSearch flightSearch) {
        return flightSearchHandler.flightSearch(flightSearch);
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
