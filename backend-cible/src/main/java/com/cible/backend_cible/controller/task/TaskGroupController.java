package com.cible.backend_cible.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.task.TaskGroupSERVICE;

@RestController
@RequestMapping("/api/task-groups")
public class TaskGroupController {

    @Autowired
    private TaskGroupSERVICE taskGroupSERVICE;

    @GetMapping("/all")
    public Iterable<TaskGroup> getAllTaskGroups() {
        return taskGroupSERVICE.getAllTaskGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGroup> getGroupById(@PathVariable Integer id) {
    try {
        TaskGroup group = taskGroupSERVICE.getGroupById(id);
        return ResponseEntity.ok(group);
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/user/{userId}")
    public List<TaskGroup> getGroupsByUser(@PathVariable Integer userId) {
        User user = new User();
        user.setId(userId);
        return taskGroupSERVICE.getGroupsByUser(user);
    }

    @PostMapping("/")
    public TaskGroup createGroup(@RequestBody TaskGroup group) {
        return taskGroupSERVICE.createGroup(group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Integer id) {
        taskGroupSERVICE.deleteGroup(id);
    }
}
