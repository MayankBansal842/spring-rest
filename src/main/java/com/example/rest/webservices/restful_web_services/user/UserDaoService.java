package com.example.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
//    userdaoservice   >>  static list

    private static List<User> users = new ArrayList<User>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"person 1", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"person 2", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"person 3", LocalDate.now().minusYears(20)));
    }

    public List<User> getAllUsers() {
        return users;
    }
    public User getUserById(int id) {
//        for (User user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;

        User user = users.stream().filter(user1 -> user1.getId() == id).findFirst().orElse(null);
        return user;
    }

    public User addUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
