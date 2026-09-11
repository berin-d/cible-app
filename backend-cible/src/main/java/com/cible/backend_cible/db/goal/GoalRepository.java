package com.cible.backend_cible.db.goal;

import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.user.User;
import com.cible.backend_cible.model.year.Year;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends CrudRepository<Goal, Integer> {

    List<Goal> findAll();

    List<Goal> findGoalByUser_IdAndYear_Year(Integer userId, String yearYear);


    @Query("SELECT DISTINCT g.year FROM Goal g WHERE g.year IS NOT NULL ORDER BY g.year")
    List<Integer> findDistinctYears();

    Year user(User user);
}
