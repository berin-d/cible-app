package com.cible.backend_cible.controller.task;

import com.cible.backend_cible.model.task.TaskAssignment;
import com.cible.backend_cible.service.task.TaskAssignmentSERVICE;
import com.cible.backend_cible.service.task.TaskSERVICE;
import com.cible.backend_cible.service.user.UserSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task-assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentSERVICE taskAssignmentSERVICE;

    @Autowired
    private UserSERVICE userSERVICE;

    @Autowired
    private TaskSERVICE taskSERVICE;

    @GetMapping("/all")
    public ResponseEntity<Iterable<TaskAssignment>> getAllTaskAssignments() {
        return ResponseEntity.ok(taskAssignmentSERVICE.getAllTaskAssignments());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskAssignment>> getByUser(@PathVariable Integer userId) {

        return userSERVICE.getUserById(userId)
                .map(user -> ResponseEntity.ok(taskAssignmentSERVICE.getByUser(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskAssignment>> getByTask(@PathVariable Integer taskId) {

        return taskSERVICE.getTaskByIdOptional(taskId)
                .map(task -> ResponseEntity.ok(taskAssignmentSERVICE.getByTask(task)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
