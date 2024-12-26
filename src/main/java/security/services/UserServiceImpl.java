package security.services;

import security.entity.User;
import security.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    UserServiceImpl() {
    }

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //method of the system under test
    @Override
    public Long gmailUserCount() {
        return
                userRepository
                        .findAll()
                        .stream().filter(user -> user.getEmail().contains("gmail.com"))
                        .count();

    }


    @Override
    public User findByName(String name) {
        return
                userRepository
                        .findByName(name);
    }

    // New updateUser method
    @Override
    public void updateUser(String name, String email) {
        User user = userRepository.findByName(name);
        if (user != null) {
            user.setEmail(email); // Update the user's email
            userRepository.saveUser(user); // Save the updated user
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    // New saveAllUsers method
    @Override
    public void saveAllUsers(List<User> users) {
        userRepository.saveAll(users);
    }


    // New deleteUser method
    @Override
    public void deleteUser(String name) {
        userRepository.deleteByName(name);
    }

    //other methods, not in use
    @Override
    public Integer xmailUserCount() {
        return null;
    }
}
