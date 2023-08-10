package com.example.microserviceexample;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class ApiController {

    @GetMapping("/users")
    String getUsers() {
        return "Greetings from users endpoint"; //currently just to test endpoint availability
    }

    @PostMapping("/registration")
    User newUser(@RequestBody User newUser) {
        //TO DO: pass input from api to User object
        return newUser;
    }

}
