package com.cible.backend_cible.db.task;

import com.cible.backend_cible.model.task.Priority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PriorityRepository extends CrudRepository<Priority, Integer> {

    Optional<Priority> findByName(String name);

    boolean existsByName(String name);
}
