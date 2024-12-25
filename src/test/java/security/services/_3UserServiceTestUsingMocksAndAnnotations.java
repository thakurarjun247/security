package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import security.repository.UserRepository;
import security.entity.User;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Must have to initialize mocks with Mockito in JUnit 5 tests.
public class _3UserServiceTestUsingMocksAndAnnotations {
    static final long GMAIL_USER_COUNT=6;
    @Mock //use this to denote the system to be stubbed or mocked
    UserRepository userRepository;


    @InjectMocks //use this to denote where to inject the mock we created, note use the implementation (UserServiceImpl) not the interface.
    UserServiceImpl userServiceImpl;
    @Test
    public void shouldFilterGmailUsersAndVerifyCountUsingMockAndAnnotations() {
        when(userRepository.findAll())
                .thenReturn(List.of(
                        // gmail
                        new User("arjun", "arjun@gmail.com"),
                        new User("yuvan", "yuvan@gmail.com"),
                        new User("kavya", "kavya@gmail.com"),
                        new User("maya", "maya@gmail.com"),
                        new User("suman", "suman@gmail.com"),
                        new User("rohan", "rohan@gmail.com"),
                        // xmail
                        new User("anil", "anil@xmail.com"),
                        new User("neha", "neha@xmail.com"),
                        new User("priya", "priya@xmail.com"),
                        // ymail
                        new User("rahul", "rahul@ymail.com"),
                        new User("ravi", "ravi@ymail.com"),
                        new User("deepa", "deepa@ymail.com"),
                        // outlook
                        new User("amit", "amit@outlook.com"),
                        new User("rekha", "rekha@outlook.com"),
                        // company
                        new User("vivek", "vivek@company.com")
                ));
        Assertions.assertEquals(GMAIL_USER_COUNT,userServiceImpl.gmailUserCount());

    }
}
