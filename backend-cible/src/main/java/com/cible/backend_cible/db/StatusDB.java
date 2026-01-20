package com.cible.backend_cible.db;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.Status;

@Repository
public interface StatusDB extends CrudRepository<Status, Integer> {
    

    Optional<Status> findByName(String name);

    boolean existsByName(String name);
}
