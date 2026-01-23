package com.cible.backend_cible.controller.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.model.task.Status;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.service.task.PrioritySERVICE;
import com.cible.backend_cible.service.task.StatusSERVICE;
import com.cible.backend_cible.service.task.TaskSERVICE;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskSERVICE taskSERVICE;

    @Autowired
    private StatusSERVICE statusSERVICE;

    @Autowired
    private PrioritySERVICE prioritySERVICE;

    @GetMapping("/all")
    public Iterable<Task> getAllTasks() {
        return taskSERVICE.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        try {
            Task task = taskSERVICE.getTaskById(id);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/status/{statusId}")
    public List<Task> getTasksByStatus(@PathVariable Integer statusId) {
        Optional<Status> optionalStatus = statusSERVICE.getStatusById(statusId);
        if (optionalStatus.isEmpty()) {
            throw new RuntimeException("Status not found with id: " + statusId);
        }
        return taskSERVICE.getTasksByStatus(optionalStatus.get());
    }
    
    @GetMapping("/priority/{priorityId}")
    public List<Task> getTasksByPriority(@PathVariable Integer priorityId) {
        Optional<Priority> optionalPriority = prioritySERVICE.getPriorityById(priorityId);
        if (optionalPriority.isEmpty()) {
            throw new RuntimeException("Priority not found with id: " + priorityId);
        }
        return taskSERVICE.getTasksByPriority(optionalPriority.get());
    }
    
    @GetMapping("/search")
    public List<Task> searchTasksByTitle(@RequestParam String keyword) {
        return taskSERVICE.searchTasksByTitle(keyword);
    }

    @PostMapping("/")
    public Task saveTask(@RequestBody Task task) {
        return taskSERVICE.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskSERVICE.deleteTask(id);
    }
}
