package security.services;

import security.entity.User;

import java.util.List;

public interface UserService {
    //method under test

    Long gmailUserCount();

    //other methods, not in use
    User findByName(String name);

    // New updateUser method
    void updateUser(String name, String email);

    // New saveAllUsers method
    void saveAllUsers(List<User> users);

    // New deleteUser method
    void deleteUser(String name);

    Integer xmailUserCount();


    String reverseUserName(String userName);
}
