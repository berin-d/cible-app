package com.cible.backend_cible.db;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.Priority;

@Repository
public interface PriorityDB extends CrudRepository<Priority, Integer> {

    Optional<Priority> findByName(String name);

    boolean existsByName(String name);
}
