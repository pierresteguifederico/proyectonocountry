package com.nocountry.c1424mjava.repository;

import com.nocountry.c1424mjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String adminEmail);

    User findByName(String name);
}
