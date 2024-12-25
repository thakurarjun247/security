package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import security.entity.User;
import security.repository.UserRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTestUsingMocks {
    private final Long GMAIL_USER_COUNT=6l;
    @Test
    public void shouldFilterGmailUsersAndVerifyCountUsingMock(){
        UserRepository userRepositoryMock = mock(UserRepository.class);
        when(userRepositoryMock.findAll()).thenReturn( List.of(
                //gmail
                new User("arjun", "arjun@gmail.com"),
                new User("yuvan", "yuvan@gmail.com"),
                new User("kavya", "kavya@gmail.com"),
                new User("maya", "maya@gmail.com"),
                new User("suman", "suman@gmail.com"),
                new User("rohan", "rohan@gmail.com"),
                //xmail
                new User("anil", "anil@xmail.com"),
                new User("neha", "neha@xmail.com"),
                new User("priya", "priya@xmail.com"),
                //ymail
                new User("rahul", "rahul@ymail.com"),
                new User("ravi", "ravi@ymail.com"),
                new User("deepa", "deepa@ymail.com"),
                //outlook
                new User("amit", "amit@outlook.com"),
                new User("rekha", "rekha@outlook.com"),
                //company
                new User("vivek", "vivek@company.com")
        ));
        UserService userService= new UserServiceImpl(userRepositoryMock);
        //this is what we used in stub, but here the framework does it for us.
        //UserService userService=new UserServiceImpl(new StubUserRepositoryImpl());
        Assertions.assertEquals(GMAIL_USER_COUNT, userService.gmailUserCount());
    }
}
