package security.services;

import security.entity.User;

public interface UserService {
    User findByName(String name);
    Integer xmailUserCount();

    Long gmailUserCount();


}
