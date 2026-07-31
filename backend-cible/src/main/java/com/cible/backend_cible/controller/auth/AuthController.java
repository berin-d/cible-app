package com.cible.backend_cible.controller.auth;


import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:1420"})
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saved = authService.register(user);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return authService.verify(user);
    }
}
