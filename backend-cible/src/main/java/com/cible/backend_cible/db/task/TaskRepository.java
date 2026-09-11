package com.cible.backend_cible.db.task;

import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.model.task.Status;
import com.cible.backend_cible.model.task.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
    
    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);

    List<Task> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT DISTINCT YEAR(t.dueDate) FROM Task t WHERE t.dueDate IS NOT NULL ORDER BY 1")
    List<Integer> findDistinctYears();

    List<Task> findByGoal_Id(Integer groupId);

}
