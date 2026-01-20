package com.cible.backend_cible.service.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.UserDB;
import com.cible.backend_cible.model.task.User;

@Service
public class UserSERVICE {

    @Autowired
    private UserDB userDB;

    public Iterable<User> getAllUsers(){
        return userDB.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userDB.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userDB.findByEmail(email);
    }

    public Optional<User> getUserByUsername(String username) {
        return userDB.findByUsername(username);
    }

    public User createUser(User user) {
        return userDB.save(user);
    }

    public boolean emailExists(String email) {
        return userDB.existsByEmail(email);
    }

    public boolean usernameExists(String username) {
        return userDB.existsByUsername(username);
    }

    public void deleteUser(Integer id) {
        userDB.deleteById(id);
    }

}
