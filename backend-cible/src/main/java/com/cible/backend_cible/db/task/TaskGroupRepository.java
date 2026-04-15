package com.cible.backend_cible.db.task;

import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskGroupRepository extends CrudRepository<TaskGroup, Integer> {
    
        List<TaskGroup> findAll();


        List<TaskGroup> findByUser(User user);

        List<TaskGroup> findByNameContainingIgnoreCase(String name);
    
        boolean existsByUserAndName(User user, String name);

        List<TaskGroup> findByUser_Id(Integer userId);
}
