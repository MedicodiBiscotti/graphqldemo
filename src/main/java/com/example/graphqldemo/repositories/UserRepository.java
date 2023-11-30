package com.example.graphqldemo.repositories;

import com.example.graphqldemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}