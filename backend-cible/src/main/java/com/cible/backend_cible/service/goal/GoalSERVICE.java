package com.cible.backend_cible.service.goal;

import com.cible.backend_cible.db.goal.GoalRepository;
import com.cible.backend_cible.mapper.task.GoalMapper;
import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalSERVICE {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private GoalMapper goalMapper;

    public List<GoalDTO> getAllGoals() {
        return goalRepository.findAll().stream()
                .map(goalMapper::toDTO)
                .toList();
    }

    public Goal createGroup(Goal group) {
        return goalRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        goalRepository.deleteById(id);
    }

    public Optional<Goal> getGroupByIdOptional(Integer id) {
        return goalRepository.findById(id);
    }

    public boolean existsById(Integer id) {
        return goalRepository.existsById(id);
    }

    public Goal saveGoal(GoalDTO goalDTO, User user) {
        Goal goal = goalMapper.toEntity(goalDTO);
        goal.setUser(user);
        return goalRepository.save(goal);
    }


    public List<Integer> getDistinctYears() {
        return goalRepository.findDistinctYears();
    }

    public List<GoalDTO> getTaskGroupsByYear(int year) {
        return goalRepository.findByYear(year).stream()
                .map(goalMapper::toDTO)
                .toList();
    }

}
