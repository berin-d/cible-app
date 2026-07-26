
package com.cible.backend_cible.controller.task;

import com.cible.backend_cible.model.filterDtos.UserFilterDTO;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.service.user.UserSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/filter")
    public ResponseEntity<Iterable<User>> filterUsers(
            @RequestBody UserFilterDTO filter) {

        return ResponseEntity.ok(userSERVICE.filterUsers(filter));
    }

}