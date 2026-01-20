package com.cible.backend_cible.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cible.backend_cible.db.UserDB;
import com.cible.backend_cible.model.task.Role;
import com.cible.backend_cible.model.task.User;



/*
1.
docker-compose up --build
2.
docker compose up -d



for testing -----> "mvn test"
(in commandline)

*/
@SpringBootTest
public class UserDBTest {

    @Autowired
    private UserDB userDB;


    @BeforeEach
    void cleanDB() {
        userDB.deleteAll();
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("Alice");
        user.setEmail("alice@example.com");
        user.setPasswordHash("password123");
        user.setRole(Role.USER);
        user.setIsActive(true);
        user.setEmailVerified(false);
        user.setAccountLocked(false);
        user.setFailedLoginAttempts(0);
     

        userDB.save(user);
    
        assertTrue(userDB.findById(user.getId()).isPresent());
    }
    
}
