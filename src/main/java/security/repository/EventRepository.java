package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
