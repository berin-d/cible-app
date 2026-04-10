package com.cible.backend_cible.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.service.task.TaskGroupSERVICE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/task-groups")
public class TaskGroupController {

    @Autowired
    private TaskGroupSERVICE taskGroupSERVICE;

    @GetMapping("/all")
    public ResponseEntity<List<TaskGroupDTO>> getAllTaskGroups() {
        return ResponseEntity.ok(taskGroupSERVICE.getAllTaskGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGroup> getGroupById(@PathVariable Integer id) {
        return taskGroupSERVICE.getGroupByIdOptional(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<TaskGroup> createGroup(@RequestBody TaskGroup group) {
        TaskGroup saved = taskGroupSERVICE.createGroup(group);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Integer id) {
        if (!taskGroupSERVICE.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskGroupSERVICE.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<TaskGroupDTO>> getTaskGroupsByYear(@PathVariable int year) {
        return ResponseEntity.ok(taskGroupSERVICE.getTaskGroupsByYear(year));
    }
}
