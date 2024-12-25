package security.services;

import security.entity.User;
import security.repository.UserRepository;

public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    UserServiceImpl(){}
    UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public Integer xmailUserCount() {
        return null;
    }
    @Override
    public Long gmailUserCount() {
       return
                userRepository
                        .findAll()
                        .stream().filter(user -> user.getEmail().contains("gmail.com"))
                        .count();

    }
}
