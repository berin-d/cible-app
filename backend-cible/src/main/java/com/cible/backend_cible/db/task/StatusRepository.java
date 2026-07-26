package com.cible.backend_cible.db.task;


import com.cible.backend_cible.model.task.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
    

    Optional<Status> findByName(String name);

    boolean existsByName(String name);
}
