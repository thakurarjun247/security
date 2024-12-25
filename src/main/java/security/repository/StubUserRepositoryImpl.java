package security.repository;

import security.entity.User;

import java.util.List;

public class StubUserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        return List.of(
                //gmail
                new User("arjun", "arjun@gmail.com"),
                new User("yuvan", "yuvan@gmail.com"),
                new User("kavya", "kavya@gmail.com"),
                new User("maya", "maya@gmail.com"),
                new User("suman", "suman@gmail.com"),
                new User("rohan", "rohan@gmail.com"),
                //xmail
                new User("anil", "anil@xmail.com"),
                new User("neha", "neha@xmail.com"),
                new User("priya", "priya@xmail.com"),
                //ymail
                new User("rahul", "rahul@ymail.com"),
                new User("ravi", "ravi@ymail.com"),
                new User("deepa", "deepa@ymail.com"),
                //outlook
                new User("amit", "amit@outlook.com"),
                new User("rekha", "rekha@outlook.com"),
                //company
                new User("vivek", "vivek@company.com")
        );

    }
}
