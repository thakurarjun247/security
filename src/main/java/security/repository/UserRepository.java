package security.repository;

import security.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findByName(String name);


    void deleteByName(String name);

    void saveAll(List<User> users);

    void saveUser(User user);
}
