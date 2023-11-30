package com.example.graphqldemo.controllers;

import com.example.graphqldemo.entities.User;
import com.example.graphqldemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @QueryMapping(name = "user")
    public User getUser(@Argument Long id) {
        return userService.getUser(id);
    }

    @QueryMapping(name = "users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @MutationMapping
    public User createUser(@Argument User user) {
        return userService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument User user) {
        return userService.updateUser(user);
    }

    @MutationMapping
    public boolean deleteUser(@Argument Long id) {
        userService.deleteUser(id);
        return true;
    }
}
