
package com.cible.backend_cible.controller.task;


import com.cible.backend_cible.model.dtos.auth.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.task.UserSERVICE;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:1420"})
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

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody AuthDTO authDTO) {
        System.out.println("auth: " + authDTO);
        return userSERVICE.getUserByEmailAndPassword(authDTO.getEmail(), authDTO.getPassword())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saved = userSERVICE.createUser(user);
        return ResponseEntity.ok(saved);
    }
}