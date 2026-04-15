package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.TaskGroupRepository;
import com.cible.backend_cible.mapper.task.TaskGroupMapper;
import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskGroupSERVICE {
    
    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Autowired
    private TaskGroupMapper taskGroupMapper;

    public List<TaskGroupDTO> getAllTaskGroups(){
        return taskGroupRepository.findAll().stream()
            .map(taskGroupMapper::toDTO)
            .toList();
    }

    public TaskGroup getGroupById(Integer id) {
        return taskGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskGroup not found"));
    }

    public List<TaskGroup> getGroupsByUser(User user) {
        return taskGroupRepository.findByUser(user);
    }

    public TaskGroup createGroup(TaskGroup group) {
        return taskGroupRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        taskGroupRepository.deleteById(id);
    }

    public Optional<TaskGroup> getGroupByIdOptional(Integer id) {
        return taskGroupRepository.findById(id);
    }
    
    public boolean existsById(Integer id) {
        return taskGroupRepository.existsById(id);
    }

    public List<TaskGroup> getGroupsByUserId(Integer userId) {
        return taskGroupRepository.findByUser_Id(userId);
    }
    
}
