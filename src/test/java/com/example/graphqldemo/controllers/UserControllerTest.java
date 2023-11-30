package com.example.graphqldemo.controllers;

import com.example.graphqldemo.entities.User;
import com.example.graphqldemo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@GraphQlTest
class UserControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private UserService userService;

    @Test
    void getUser() {
        long id = 1;

        given(userService.getUser(1L)).willReturn(new User(id, "John", "Smith", "john@gmail.com"));

        graphQlTester
                .documentName("getUser")
                .variable("id", id)
                .execute()
                .path("user").entity(User.class)
                .path("user.id").entity(Long.class).isEqualTo(id)
                .path("user.firstName").entity(String.class).isEqualTo("John")
                .path("user.lastName").entity(String.class).isEqualTo("Smith")
                .path("user.email").entity(String.class).isEqualTo("john@gmail.com");

        verify(userService).getUser(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    void getUsers() {
        given(userService.getUsers()).willReturn(
                List.of(
                        new User(1L, "John", "Smith", "john@gmail.com"),
                        new User(2L, "Jane", "Doe", "jane@gmail.com")));

        graphQlTester
                .document("{ users { id firstName lastName email } }")
                .execute()
                .path("users").entityList(User.class).hasSize(2);

        verify(userService).getUsers();
        verifyNoMoreInteractions(userService);
    }
}