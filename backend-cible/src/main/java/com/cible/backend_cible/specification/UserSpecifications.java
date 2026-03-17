package com.cible.backend_cible.specification;

import org.springframework.data.jpa.domain.PredicateSpecification;

import com.cible.backend_cible.model.task.Role;
import com.cible.backend_cible.model.task.User;

public class UserSpecifications {
    
   public static PredicateSpecification<User> hasUsername(String username) {
        return (from, cb) ->
                cb.equal(from.get("username"), username);
    }

    public static PredicateSpecification<User> hasEmail(String email) {
        return (from, cb) ->
                cb.equal(from.get("email"), email);
    }

    public static PredicateSpecification<User> hasRole(Role role) {
        return (from, cb) ->
                cb.equal(from.get("role"), role);
    }

    public static PredicateSpecification<User> isActive(Boolean isActive) {
        return (from, cb) ->
                cb.equal(from.get("isActive"), isActive);
    }

    public static PredicateSpecification<User> isEmailVerified(Boolean emailVerified) {
        return (from, cb) ->
                cb.equal(from.get("emailVerified"), emailVerified);
    }

    public static PredicateSpecification<User> isAccountLocked(Boolean accountLocked) {
        return (from, cb) ->
                cb.equal(from.get("accountLocked"), accountLocked);
    }

    public static PredicateSpecification<User> failedAttemptsGreaterThan(Integer attempts) {
        return (from, cb) ->
                cb.greaterThan(from.get("failedLoginAttempts"), attempts);
    }

}
