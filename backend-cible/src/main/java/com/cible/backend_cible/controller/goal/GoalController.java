package com.cible.backend_cible.controller.goal;

import com.cible.backend_cible.mapper.task.GoalMapper;
import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.model.user.UserAuth;
import com.cible.backend_cible.service.goal.GoalSERVICE;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @GetMapping("/{id}")
//    public ResponseEntity<Goal> getGroupById(@PathVariable Integer id) {
//        return goalSERVICE.getGroupByIdOptional(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }


    @GetMapping("/years")
    public List<Integer> getYears() {
        return goalSERVICE.getDistinctYears();
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<GoalDTO>> getTaskGroupsByYear(@PathVariable int year) {
        return ResponseEntity.ok(goalSERVICE.getTaskGroupsByYear(year));
    }

    @PostMapping("/add")
    public ResponseEntity<GoalDTO> saveGoal(@RequestBody GoalDTO goalDTO, @AuthenticationPrincipal UserAuth userAuth) {
        User user = userAuth.getUser();
        System.out.println("User : " + user);
        Goal saved = goalSERVICE.saveGoal(goalDTO, user);
        return ResponseEntity.ok(goalMapper.toDTO(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Integer id) {
        if (!goalSERVICE.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        goalSERVICE.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }



}
