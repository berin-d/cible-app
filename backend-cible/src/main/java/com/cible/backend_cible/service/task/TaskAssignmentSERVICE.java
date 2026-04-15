package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.TaskAssignmentRepository;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.TaskAssignment;
import com.cible.backend_cible.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentSERVICE {
    
    @Autowired
    private TaskAssignmentRepository taskAssignmentRepository;

    public Iterable<TaskAssignment> getAllTaskAssignments(){
        return taskAssignmentRepository.findAll();
    }
    
    public List<TaskAssignment> getByUser(User user) {
        return taskAssignmentRepository.findByUser(user);
    }

    public List<TaskAssignment> getByTask(Task task) {
        return taskAssignmentRepository.findByTask(task);
    }
}
