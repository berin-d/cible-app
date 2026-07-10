package com.cible.backend_cible.controller.goal;

import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.service.goal.GoalSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-groups")
public class GoalController {

    @Autowired
    private GoalSERVICE goalSERVICE;

    @GetMapping("/all")
    public ResponseEntity<List<GoalDTO>> getAllTaskGroups() {
        return ResponseEntity.ok(goalSERVICE.getAllTaskGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGroupById(@PathVariable Integer id) {
        return goalSERVICE.getGroupByIdOptional(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Goal> createGroup(@RequestBody Goal group) {
        Goal saved = goalSERVICE.createGroup(group);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Integer id) {
        if (!goalSERVICE.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        goalSERVICE.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<GoalDTO>> getTaskGroupsByYear(@PathVariable int year) {
        return ResponseEntity.ok(goalSERVICE.getTaskGroupsByYear(year));
    }
}
