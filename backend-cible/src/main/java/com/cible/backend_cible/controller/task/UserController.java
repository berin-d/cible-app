
package com.cible.backend_cible.controller.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.task.UserSERVICE;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserSERVICE userSERVICE;

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userSERVICE.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userSERVICE.getUserById(id);

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user.get());
    }


    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userSERVICE.createUser(user);
    }
}