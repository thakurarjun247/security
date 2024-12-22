package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import security.entity.Event;
import security.repository.EventRepository;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    @Mock
    EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventServiceImpl;

    @Test
    public void shouldSaveEventAndReturn() {
        Event eventToSave = new Event(11, "my event");
        when(eventRepository.save(eventToSave)).thenReturn(eventToSave);
        Event savedEvent = eventServiceImpl.save(eventToSave);
        System.out.println(eventToSave.getName() == savedEvent.getName());
        Assertions.assertEquals(eventToSave.getName(), savedEvent.getName());
    }

}
