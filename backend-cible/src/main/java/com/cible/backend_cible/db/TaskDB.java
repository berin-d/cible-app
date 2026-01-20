package com.cible.backend_cible.db;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.model.task.Task;

@Repository
public interface TaskDB extends CrudRepository<Task, Integer> {
    
    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);

    List<Task> findByTitleContainingIgnoreCase(String title);

    List<Task> findByIsArchivedFalse();   

}
