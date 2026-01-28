package com.cible.backend_cible.db.task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.task.User;

@Repository
public interface TaskGroupDB extends CrudRepository<TaskGroup, Integer> {
    
        List<TaskGroup> findByUser(User user);

        List<TaskGroup> findByNameContainingIgnoreCase(String name);
    
        boolean existsByUserAndName(User user, String name);

        List<TaskGroup> findByUserId(Integer userId);
}
