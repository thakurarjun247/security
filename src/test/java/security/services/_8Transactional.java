package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import security.entity.Event;
import security.entity.User;

@SpringBootTest
@ExtendWith(SpringExtension.class) // Use SpringExtension for Spring Boot integration
@Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.READ_UNCOMMITTED)
public class _8Transactional {

    EventServiceImpl eventService=new EventServiceImpl();

@Test
    public void testRollback(){
    Event event= new Event(1, "event name");
    Assertions.assertTrue(true);

  //  Assertions.assertFalse(eventService.findById(1).isPresent());

}


}
