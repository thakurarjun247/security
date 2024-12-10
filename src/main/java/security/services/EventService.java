package security.services;

import org.springframework.data.domain.Page;
import security.entity.Event;

import java.util.List;

public interface EventService {
    Event save(Event event);

    Page<Event> findAllPaginated(int page, int size);

    List<Event> findAll();
}
