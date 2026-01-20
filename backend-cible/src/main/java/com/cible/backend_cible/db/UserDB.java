package com.cible.backend_cible.db;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.User;

@Repository
public interface UserDB extends CrudRepository<User, Integer> {

      Optional<User> findByEmail(String email);

      Optional<User> findByUsername(String username);
  
      boolean existsByEmail(String email);
  
      boolean existsByUsername(String username);
}
