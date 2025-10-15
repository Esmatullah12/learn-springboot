package com.library.library.springboot.service;

import com.library.library.springboot.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int count = 0;

    static {
        users.add(new User(++count, "Esmat", LocalDate.now().minusYears(20)));
        users.add(new User(++count, "Ali", LocalDate.now().minusYears(20)));
        users.add(new User(++count, "Ahmad", LocalDate.now().minusYears(20)));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User createUser(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }

    public  void deleteUser(int id){
        Predicate<? super User> predicate =user -> user.getId().equals(id);
    }
}
