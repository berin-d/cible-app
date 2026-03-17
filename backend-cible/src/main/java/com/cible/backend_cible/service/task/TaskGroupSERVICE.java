package com.cible.backend_cible.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.TaskGroupDB;
import com.cible.backend_cible.mapper.task.TaskGroupMapper;
import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.task.User;

@Service
public class TaskGroupSERVICE {
    
    @Autowired
    private TaskGroupDB taskGroupDB;

    @Autowired
    private TaskGroupMapper taskGroupMapper;

    public List<TaskGroupDTO> getAllTaskGroups(){
        return taskGroupDB.findAll().stream()
            .map(taskGroupMapper::toDTO)
            .toList();
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

    public Optional<TaskGroup> getGroupByIdOptional(Integer id) {
        return taskGroupDB.findById(id);
    }
    
    public boolean existsById(Integer id) {
        return taskGroupDB.existsById(id);
    }

    
}
