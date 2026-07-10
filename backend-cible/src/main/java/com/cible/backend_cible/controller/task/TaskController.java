package com.cible.backend_cible.controller.task;

import com.cible.backend_cible.mapper.task.TaskMapper;
import com.cible.backend_cible.model.dtos.task.TaskDTO;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.service.task.PrioritySERVICE;
import com.cible.backend_cible.service.task.StatusSERVICE;
import com.cible.backend_cible.service.task.TaskSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskSERVICE taskSERVICE;

    @Autowired
    private StatusSERVICE statusSERVICE;

    @Autowired
    private PrioritySERVICE prioritySERVICE;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Task>> getAllTasks() {
        return ResponseEntity.ok(taskSERVICE.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        return taskSERVICE.getTaskByIdOptional(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/status/{statusId}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable Integer statusId) {
        return statusSERVICE.getStatusById(statusId)
                .map(status -> ResponseEntity.ok(taskSERVICE.getTasksByStatus(status)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/priority/{priorityId}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable Integer priorityId) {
        return prioritySERVICE.getPriorityById(priorityId)
                .map(priority -> ResponseEntity.ok(taskSERVICE.getTasksByPriority(priority)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasksByTitle(@RequestParam String keyword) {
        return ResponseEntity.ok(taskSERVICE.searchTasksByTitle(keyword));
    }

    @PostMapping("/")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task saved = taskSERVICE.saveTask(task);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        if (!taskSERVICE.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskSERVICE.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<TaskDTO>> getTasksByGroupId(@PathVariable Integer groupId) {
        return ResponseEntity.ok(
            taskSERVICE.getTasksByGroupId(groupId).stream()
                .map(taskMapper::toDto)
                .toList()
        );
    }

    @PutMapping("/{id}/completed")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id) {
        Task task = taskSERVICE.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        task.setIsCompleted(true);
        Task updated = taskSERVICE.saveTask(task);
        return ResponseEntity.ok(updated);
    }
}
