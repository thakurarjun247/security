package security.event;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.event.Event;
import security.event.EventRepository;

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

    // Save a new event
    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.ok(savedEvent);
    }
}
