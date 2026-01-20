package com.cible.backend_cible.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.TaskDB;
import com.cible.backend_cible.model.task.Task;

@Service
public class TaskSERVICE {
    
    @Autowired
    private TaskDB taskDB;

    public Iterable<Task> getAllTasks(){
        return taskDB.findAll();
    }
}
