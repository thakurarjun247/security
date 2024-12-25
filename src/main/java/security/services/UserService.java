package security.services;

import security.entity.User;

public interface UserService {
    //method under test

    Long gmailUserCount();

    //other methods, not in use
    User findByName(String name);

    Integer xmailUserCount();


}
