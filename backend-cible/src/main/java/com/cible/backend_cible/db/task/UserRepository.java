package com.cible.backend_cible.db.task;

import java.util.Optional;

import com.cible.backend_cible.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        JpaRepository<User, Integer>,
        JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);
}
