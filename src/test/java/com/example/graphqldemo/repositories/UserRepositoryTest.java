package com.example.graphqldemo.repositories;

import com.example.graphqldemo.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void getUser() {
        long id = 1;
        User user = userRepository.findById(id).orElse(null);
        assertEquals("John", user.getFirstName());
    }
}