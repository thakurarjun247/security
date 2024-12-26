package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import security.entity.User;
import security.repository.UserRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        Assertions.assertEquals("yuvan",stringArgumentCaptor.getValue(), "expected argument passed to the method is 'yuvan'");
    }

}
