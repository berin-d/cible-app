package com.cible.backend_cible.service.task;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.UserRepository;
import com.cible.backend_cible.model.filterDtos.UserFilterDTO;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.specification.UserSpecifications;

@Service
public class UserSERVICE {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
    

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
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

    return userRepository .findAll(spec);
}

}
