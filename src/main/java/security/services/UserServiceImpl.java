package security.services;

import security.entity.User;
import security.repository.UserRepository;

import java.util.stream.Collectors;

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

    //other methods, not in use
    @Override
    public User findByName(String name) {
        return
                userRepository
                        .findAll()
                        .stream()
                        .filter(user -> user.getName().equalsIgnoreCase(name))
                        .collect(Collectors.toList())
                        .getFirst();
    }

    @Override
    public Integer xmailUserCount() {
        return null;
    }
}
