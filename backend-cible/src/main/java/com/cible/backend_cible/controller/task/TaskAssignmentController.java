package com.cible.backend_cible.controller.task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.TaskAssignment;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.task.TaskAssignmentSERVICE;
import com.cible.backend_cible.service.task.TaskSERVICE;
import com.cible.backend_cible.service.task.UserSERVICE;

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
    public Iterable<TaskAssignment> getAllTaskAssignments() {
        return taskAssignmentSERVICE.getAllTaskAssignments();
    }

    @GetMapping("/user/{userId}")
    public List<TaskAssignment> getByUser(@PathVariable Integer userId) {
        User user = userSERVICE.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return taskAssignmentSERVICE.getByUser(user);
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignment> getByTask(@PathVariable Integer taskId) {
        Task task = taskSERVICE.getTaskById(taskId);
        return taskAssignmentSERVICE.getByTask(task);
    }

}
