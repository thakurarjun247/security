package security.controllers;

import security.exceptionhandling.EventNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import security.entity.Event;
import security.services.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class Controller {

    @Autowired
    private EventService eventService;


    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    //todo: fix this

    // Endpoint to fetch paginated events
    @GetMapping("/paginated")
    public Page<Event> getPaginatedEvents(
            @RequestParam(defaultValue = "0") int page, // Default to page 0
            @RequestParam(defaultValue = "2") int size // Default to 2 items per page
    ) {
        //    return eventRepository.findAll(PageRequest.of(page, size)); // Correct
        return eventService.findAllPaginated(page, size);
    }


    // Save a new event
    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        Event savedEvent = eventService.save(event);
        return ResponseEntity.ok(savedEvent);
    }
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable("eventId") Integer eventId){
        Optional<Event> event=eventService.findById(eventId);
        if (!event.isPresent())
            throw new EventNotFoundException("can't find event with id "+eventId);
        return event.get();
    }


    //interservice communication working just fine.
    @GetMapping("/jobhunter")
    public String getJobHunterData() {
        final RestTemplate restTemplate = new RestTemplate();
        // Call the external service and return the response directly
        return restTemplate.getForObject("http://localhost:8081/", String.class);
    }
}
