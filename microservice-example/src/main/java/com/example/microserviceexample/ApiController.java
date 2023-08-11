package com.example.microserviceexample;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ApiController {

    //To improve: add DELETE and PUT methods
    
    private List<User> users = createList();

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> firstPage() {
        return users;
    }

    @PostMapping("/registration")
    public User create(@RequestBody User user) {
        users.add(user);
        //System.out.println(users);
        return user;
    }

    private static List<User> createList() {
        List<User> userList = new ArrayList<>();

        User user1 = new User("JaneDoe", "Password123_", "24.48.0.1");
        User user2 = new User("JohnDoe", "Password789#", "24.48.0.2");

        userList.add(user1);
        userList.add(user2);
        return userList;

    }

}
