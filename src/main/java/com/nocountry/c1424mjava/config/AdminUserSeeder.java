package com.nocountry.c1424mjava.config;

import com.nocountry.c1424mjava.model.User;
import com.nocountry.c1424mjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserSeeder implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    private void seedAdmin() {
        String adminName = "Admin";
        String adminEmail = "admin@gmail.com";
        String adminPassword = "123456789";

        if (!userRepository.findByEmail(adminEmail).isPresent()) {
            userRepository.save(new User(adminName, adminEmail, new BCryptPasswordEncoder().encode(adminPassword)));
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedAdmin();
    }
}
