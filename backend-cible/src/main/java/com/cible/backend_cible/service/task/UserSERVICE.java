package com.cible.backend_cible.service.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.UserDB;
import com.cible.backend_cible.model.filterDtos.UserFilterDTO;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.specification.UserSpecifications;

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

    public Iterable<User> filterUsers(UserFilterDTO filter) {

    PredicateSpecification<User> spec = PredicateSpecification.allOf();

    if (filter.getUsername() != null) {
        spec = spec.and(UserSpecifications.hasUsername(filter.getUsername()));
    }

    if (filter.getEmail() != null) {
        spec = spec.and(UserSpecifications.hasEmail(filter.getEmail()));
    }

    if (filter.getRole() != null) {
        spec = spec.and(UserSpecifications.hasRole(filter.getRole()));
    }

    if (filter.getIsActive() != null) {
        spec = spec.and(UserSpecifications.isActive(filter.getIsActive()));
    }

    if (filter.getEmailVerified() != null) {
        spec = spec.and(UserSpecifications.isEmailVerified(filter.getEmailVerified()));
    }

    if (filter.getAccountLocked() != null) {
        spec = spec.and(UserSpecifications.isAccountLocked(filter.getAccountLocked()));
    }

    if (filter.getFailedAttemptsGreaterThan() != null) {
        spec = spec.and(
            UserSpecifications.failedAttemptsGreaterThan(
                filter.getFailedAttemptsGreaterThan()
            )
        );
    }

    return userDB.findAll(spec);
}

}
