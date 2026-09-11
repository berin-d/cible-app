package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.TaskRepository;
import com.cible.backend_cible.mapper.task.TaskMapper;
import com.cible.backend_cible.model.dtos.task.TaskDTO;
import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.model.task.Status;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskSERVICE {
    
    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByPriority(Priority priority) {
        return taskRepository.findByPriority(priority);
    }
    
    public Optional<Task> getTaskByIdOptional(Integer id) {
        return taskRepository.findById(id);
    }
    

    public List<Task> searchTasksByTitle(String keyword) {
        return taskRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public Task save(TaskDTO taskDto, User user) {
        Task task = TaskMapper.INSTANCE.toEntity(taskDto);
        task.setUser(user);
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return taskRepository.existsById(id);
    }
    
    public List<Task> getTasksByGroupId(Integer groupId) {
        return taskRepository.findByGoal_Id(groupId);
    }
}
