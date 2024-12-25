package security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import security.entity.Event;
import security.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        Event savedEvent = eventRepository.save(event);
        return savedEvent;
    }

    @Override
    public Page<Event> findAllPaginated(int page, int size) {
        //    return eventRepository.findAll(PageRequest.of(page, size)); // Correct
        return eventRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Event> findById(Integer eventId) {
        return eventRepository.findById(eventId);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

}
