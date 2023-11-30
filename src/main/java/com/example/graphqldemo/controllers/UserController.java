package com.example.graphqldemo.controllers;

import com.example.graphqldemo.entities.User;
import com.example.graphqldemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @QueryMapping(name = "user")
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @QueryMapping(name = "users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
