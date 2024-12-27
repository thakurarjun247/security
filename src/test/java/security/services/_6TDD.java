package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;

@ExtendWith(MockitoExtension.class)
public class _6TDD {


    @Test
    public void testReverseUserName(){
        String userName="abc";
        UserService userService= new UserServiceImpl();
        String reversed=userService.reverseUserName(userName);
        Assertions.assertEquals("cba", reversed);
    }
}
