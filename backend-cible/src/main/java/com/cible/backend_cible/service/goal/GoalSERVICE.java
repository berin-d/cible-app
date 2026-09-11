package com.cible.backend_cible.service.goal;

import com.cible.backend_cible.db.goal.GoalRepository;
import com.cible.backend_cible.db.year.YearRepository;
import com.cible.backend_cible.mapper.task.GoalMapper;
import com.cible.backend_cible.model.dtos.goal.GoalDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.model.year.Year;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalSERVICE {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private YearRepository yearRepository;

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

    public Goal addgoal(GoalDTO goalDTO, User user) {
        Goal goal = goalMapper.toEntity(goalDTO);


        Year year = yearRepository.findByYearAndUser(goalDTO.getYear(), user)
                .orElseGet(() -> {
                    Year newYear = new Year();
                    newYear.setYear(goalDTO.getYear());
                    return yearRepository.save(newYear);
                });

        goal.setYear(year);
        goal.setUser(user);
        return goalRepository.save(goal);
    }


    public List<Integer> getDistinctYears() {
        return goalRepository.findDistinctYears();
    }

    public List<GoalDTO> getTaskGroupsByYearAndUser(String year, int userId) {
        return goalRepository.findGoalByUser_IdAndYear_Year(userId, year).stream()
                .map(goalMapper::toDTO)
                .toList();
    }

}
