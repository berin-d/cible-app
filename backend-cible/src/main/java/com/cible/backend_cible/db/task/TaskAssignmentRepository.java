package com.cible.backend_cible.db.task;

import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.TaskAssignment;
import com.cible.backend_cible.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskAssignmentRepository extends CrudRepository<TaskAssignment, Integer> {
    

    List<TaskAssignment> findByUser(User user);

    List<TaskAssignment> findByTask(Task task);

    boolean existsByUserAndTask(User user, Task task);

    Optional<TaskAssignment> findByUserAndTask(User user, Task task);

    void deleteByUserAndTask(User user, Task task);
}
