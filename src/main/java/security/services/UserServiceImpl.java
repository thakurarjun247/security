package security.services;

import security.entity.User;
import security.repository.UserRepository;

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

    //other methods, not in use
    @Override
    public Integer xmailUserCount() {
        return null;
    }
}
