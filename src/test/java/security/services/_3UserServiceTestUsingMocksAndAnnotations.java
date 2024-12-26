package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import security.entity.User;
import security.repository.UserRepository;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Must have to initialize mocks with Mockito in JUnit 5 tests.
public class _3UserServiceTestUsingMocksAndAnnotations {
    static final long GMAIL_USER_COUNT = 6;

    //dummy db entries put in a variable for using now forward, so that we don't have to create it for every test case
    final List<User> allUsers = List.of(
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
    );
    @Mock //use this to denote the system to be stubbed or mocked
    UserRepository userRepository;
    
    @InjectMocks //use this to denote where to inject the mock we created, note use the implementation (UserServiceImpl) not the interface.

    UserServiceImpl userServiceImpl;

    /*
    * The @InjectMocks annotation is used to create an instance of the class under test (which, in your case, is UserServiceImpl). This is where the mock dependencies (like UserRepository) are injected.
@InjectMocks does not inject mocks into interfaces directly because interfaces cannot be instantiated (they don't have a constructor).
* */
    @Test
    public void shouldFilterGmailUsersAndVerifyCountUsingMockAndAnnotations() {
        when(userRepository.findAll())
                .thenReturn(allUsers);

        Assertions.assertEquals(GMAIL_USER_COUNT, userServiceImpl.gmailUserCount());
    }

    @Test
    public void shouldVerifyIfTheFindAllMethodIsCalled() {

        when(userRepository.findAll()).thenReturn(allUsers);
        //verify that findAll() was called, it was called by the above code

        //Verifies certain behavior happened once.

        Long actualGmailCount = userServiceImpl.gmailUserCount();
        verify(userRepository).findAll();
        Assertions.assertEquals(GMAIL_USER_COUNT, actualGmailCount);
    }

    @Test()
    public void testSizeOfListMock() {

        List mockList = mock(List.class);
        when(mockList.size()).thenThrow(new IndexOutOfBoundsException());
        // Assert that the exception is thrown
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            mockList.size(); // Call the method that should throw the exception
        });

    }

    @Test
    public void testFindByName() {
        when(userRepository.findAll()).thenReturn(allUsers);
        User yuvanUser = userServiceImpl.findByName("yuvan");
        Assertions.assertEquals("yuvan@gmail.com", yuvanUser.getEmail());
        Assertions.assertEquals("yuvan", yuvanUser.getName());

    }
}
