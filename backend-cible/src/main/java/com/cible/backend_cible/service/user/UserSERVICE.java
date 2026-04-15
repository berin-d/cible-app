package com.cible.backend_cible.service.user;

import com.cible.backend_cible.db.task.UserRepository;
import com.cible.backend_cible.model.filterDtos.UserFilterDTO;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.specification.UserSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
