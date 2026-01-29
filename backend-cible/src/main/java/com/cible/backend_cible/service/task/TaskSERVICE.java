package com.cible.backend_cible.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.TaskDB;
import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.model.task.Status;
import com.cible.backend_cible.model.task.Task;

@Service
public class TaskSERVICE {
    
    @Autowired
    private TaskDB taskDB;

    public Iterable<Task> getAllTasks(){
        return taskDB.findAll();
    }

    public Task getTaskById(Integer id) {
        return taskDB.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getTasksByStatus(Status status) {
        return taskDB.findByStatus(status);
    }

    public List<Task> getTasksByPriority(Priority priority) {
        return taskDB.findByPriority(priority);
    }
    
    public Optional<Task> getTaskByIdOptional(Integer id) {
        return taskDB.findById(id);
    }
    

    public List<Task> searchTasksByTitle(String keyword) {
        return taskDB.findByTitleContainingIgnoreCase(keyword);
    }

    public Task saveTask(Task task) {
        return taskDB.save(task);
    }

    public void deleteTask(Integer id) {
        taskDB.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return taskDB.existsById(id);
    }
}
