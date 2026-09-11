package com.cible.backend_cible.controller.goal;

import com.cible.backend_cible.mapper.task.GoalMapper;
import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.model.user.UserAuth;
import com.cible.backend_cible.service.goal.GoalSERVICE;
import org.apache.commons.logging.Log;
import org.slf4j.event.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalSERVICE goalSERVICE;

    @Autowired
    private GoalMapper goalMapper;

    @GetMapping("/all")
    public ResponseEntity<List<GoalDTO>> getAllTaskGroups() {
        return ResponseEntity.ok(goalSERVICE.getAllGoals());
    }

    @GetMapping("/years")
    public List<Integer> getYears() {
        return goalSERVICE.getDistinctYears();
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<GoalDTO>> getTaskGroupsByYear(@PathVariable String year, @AuthenticationPrincipal UserAuth userAuth) {
        User user = userAuth.getUser();
        return ResponseEntity.ok(goalSERVICE.getTaskGroupsByYearAndUser(year, user.getId()));
    }

    @PostMapping("/add")
    public ResponseEntity<GoalDTO> addGoal(@RequestBody GoalDTO goalDTO, @AuthenticationPrincipal UserAuth userAuth) {
        User user = userAuth.getUser();
        Goal saved = goalSERVICE.addgoal(goalDTO, user);
        return ResponseEntity.ok(goalMapper.toDTO(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Integer id) {
        if (!goalSERVICE.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        goalSERVICE.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }



}
