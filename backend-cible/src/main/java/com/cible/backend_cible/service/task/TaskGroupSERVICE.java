package com.cible.backend_cible.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.TaskGroupDB;
import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.task.User;

@Service
public class TaskGroupSERVICE {
    
    @Autowired
    private TaskGroupDB taskGroupDB;

    public Iterable<TaskGroup> getAllTaskGroups(){
        return taskGroupDB.findAll();
    }

    public TaskGroup getGroupById(Integer id) {
        return taskGroupDB.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskGroup not found"));
    }

    public List<TaskGroup> getGroupsByUser(User user) {
        return taskGroupDB.findByUser(user);
    }

    public TaskGroup createGroup(TaskGroup group) {
        return taskGroupDB.save(group);
    }

    public void deleteGroup(Integer id) {
        taskGroupDB.deleteById(id);
    }
}
