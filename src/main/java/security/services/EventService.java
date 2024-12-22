package security.services;

import org.springframework.data.domain.Page;
import security.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event save(Event event);

    Page<Event> findAllPaginated(int page, int size);

    Optional<Event> findById(Integer eventId);

    List<Event> findAll();
}
