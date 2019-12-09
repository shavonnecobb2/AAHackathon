package com.aa.improvinghackathon.api;

import com.aa.improvinghackathon.domain.Itinerary;
import com.aa.improvinghackathon.infrastructure.service.flights.ItineraryRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.HandlerResultHandler;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final ItineraryRepository itineraryRepository = new ItineraryRepository();

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

    @GetMapping("/confirm/{id}")
    public List<FlightView> search(@PathVariable String id, HttpSession httpSession) {
        return new ItineraryView(getItineraryFromSession(id, httpSession)).getFlights();
    }

    @GetMapping("/book/{id}")
    public Object book(@PathVariable String id, HttpSession httpSession) {
        Itinerary itinerary = getItineraryFromSession(id, httpSession);
        String recordLocator = itineraryRepository.add(itinerary);
        ItineraryView itineraryView = new ItineraryView(itinerary);
        itineraryView.setRecordLocator(recordLocator);
        return itineraryView;
    }

    @GetMapping("/retrieve/{recordLocator}")
    public Object retrieve(@PathVariable String recordLocator) {
        Itinerary itinerary = itineraryRepository.get(recordLocator);
        ItineraryView itineraryView = new ItineraryView(itinerary);
        itineraryView.setRecordLocator(recordLocator);
        return itineraryView;
    }

    private Itinerary getItineraryFromSession(final String id, final HttpSession session) {
        List<Itinerary> itineraries = (List<Itinerary>) session.getAttribute("itineraries");
        return itineraries.stream().filter(itinerary -> itinerary.getId().equals(id)).findFirst().orElseThrow();
    }

    @ExceptionHandler
    public Map<String, String> errorHandler(final Exception e) {
        Map<String, String> error = new HashMap<>();
        error.put("error", e.getMessage());
        return error;
    }

}
