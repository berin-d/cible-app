package com.cible.backend_cible.db.task;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.User;

@Repository
public interface UserRepository extends 
        JpaRepository<User, Integer>,
        JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);

      Optional<User> findByUsername(String username);

      Optional<User> findByEmailAndPassword(String email, String password);
  
      boolean existsByEmail(String email);
  
      boolean existsByUsername(String username);
}
