package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import security.entity.User;
import security.repository.UserRepository;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class _5ArgumentCaptor {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    public void testFindByNameWithArgumentCaptor(){
        when(userRepository.findByName("yuvan"))
                .thenReturn(new User("yuvan","yuvan@gamil.com"));
        User user=userServiceImpl.findByName("yuvan");
        ArgumentCaptor<String> stringArgumentCaptor=ArgumentCaptor.forClass(String.class);

        //capture the argument that was passed to the findByName method of the userRepository
        verify(userRepository).findByName(stringArgumentCaptor.capture());
        //Be aware that it is recommended to use capture() only with verify()
        String argumentValue=stringArgumentCaptor.getValue();
        Assertions.assertEquals("yuvan",argumentValue, "expected argument passed to the method is 'yuvan'");
    }
@Test
    public void testSaveAllUsersWithArgumentCaptorList(){
        List<User> users = List.of(
                new User("arjun", "arjun@gmail.com"),
                new User("kavya", "kavya@gmail.com"));
        userServiceImpl.saveAllUsers(users);
        ArgumentCaptor<List<User>> listArgumentCaptor=ArgumentCaptor.forClass(List.class);
        verify(userRepository).saveAll(listArgumentCaptor.capture());
        int userListSizeCaptured = listArgumentCaptor.getValue().size();
        Assertions.assertEquals(2,userListSizeCaptured);
    }

    @Test
    public void testGetAllValuesForFindByName() {
        // Arrange, by mocking the repo behaviour
        when(userRepository.findByName("arjun")).thenReturn(new User("arjun", "arjun@gmail.com"));
        when(userRepository.findByName("kavya")).thenReturn(new User("kavya", "kavya@gmail.com"));
        when(userRepository.findByName("yuvan")).thenReturn(new User("yuvan", "yuvan@gmail.com"));

        // Act: call the SUT methods
        userServiceImpl.findByName("arjun");
        userServiceImpl.findByName("kavya");
        userServiceImpl.findByName("yuvan");

        // Capture arguments: from the mock repo
        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);
        verify(userRepository, times(3)).findByName(nameCaptor.capture());

        // Assert
        List<String> allValues = nameCaptor.getAllValues();
        Assertions.assertEquals(3, allValues.size());
        Assertions.assertEquals("arjun", allValues.get(0));
        Assertions.assertEquals("kavya", allValues.get(1));
        Assertions.assertEquals("yuvan", allValues.get(2));
    }

    @Test
    public void testMethodInvocationOrder() {
        // Arrange
        User user = new User("arjun", "arjun@gmail.com");

        // Act
        userServiceImpl.findByName("arjun");  // first method
        userServiceImpl.deleteUser("arjun"); //seond method

        // Assert
        InOrder inOrder = inOrder(userRepository);
        inOrder.verify(userRepository).findByName("arjun");  // Verify findByName is called first
        inOrder.verify(userRepository).deleteByName("arjun");  // Verify deletebyname is called second

    }

}
