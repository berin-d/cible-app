package com.cible.backend_cible.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.User;

@Repository
public interface UserDB extends CrudRepository<User, Integer> {
    
}
