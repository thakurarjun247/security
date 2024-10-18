package security.event;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.ListCrudRepository;

public interface EventRepository extends ListCrudRepository<Event, Integer> {
}
