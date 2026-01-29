
package com.cible.backend_cible.controller.task;


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
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userSERVICE.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return userSERVICE.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saved = userSERVICE.createUser(user);
        return ResponseEntity.ok(saved);
    }
}