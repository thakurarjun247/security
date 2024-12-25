package security.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import security.entity.User;
import security.repository.StubUserRepositoryImpl;

public class UserServiceTest {
    private final Long GMAIL_USER_COUNT=6l;
    @Test
    public void shouldFilterGmailUsersAndVerifyCount(){
        UserService userService=new UserServiceImpl(new StubUserRepositoryImpl());
        Assertions.assertEquals(GMAIL_USER_COUNT, userService.gmailUserCount());
    }
}
