package com.cible.backend_cible.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.TaskAssignmentDB;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.TaskAssignment;
import com.cible.backend_cible.model.task.User;

@Service
public class TaskAssignmentSERVICE {
    
    @Autowired
    private TaskAssignmentDB taskAssignmentDB;

    public Iterable<TaskAssignment> getAllTaskAssignments(){
        return taskAssignmentDB.findAll();
    }
    
    public List<TaskAssignment> getByUser(User user) {
        return taskAssignmentDB.findByUser(user);
    }

    public List<TaskAssignment> getByTask(Task task) {
        return taskAssignmentDB.findByTask(task);
    }
}
