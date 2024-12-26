package security.repository;

import security.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findByName(String name);
}
