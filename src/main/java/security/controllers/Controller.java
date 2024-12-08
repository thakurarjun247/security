package security.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import security.entity.Event;
import security.repository.EventRepository;

import java.util.List;

@RestController
@RequestMapping("/events")
public class Controller {

    @Autowired
    private EventRepository eventRepository;


    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Endpoint to fetch paginated events
    @GetMapping("/paginated")
    public Page<Event> getPaginatedEvents(
            @RequestParam(defaultValue = "0") int page, // Default to page 0
            @RequestParam(defaultValue = "10") int size // Default to 10 items per page
    ) {
        return eventRepository.findAll(PageRequest.of(page, size));
    }



    // Save a new event
    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.ok(savedEvent);
    }

    //interservice communication working just fine.
    @GetMapping("/jobhunter")
    public String getJobHunterData() {
         final RestTemplate restTemplate = new RestTemplate();
        // Call the external service and return the response directly
        return restTemplate.getForObject("http://localhost:8081/", String.class);
    }
}
