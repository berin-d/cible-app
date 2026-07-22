package com.cible.backend_cible.db.goal;

import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.task.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends CrudRepository<Goal, Integer> {

    List<Goal> findAll();

    List<Goal> findByYear(Integer year);


    @Query("SELECT DISTINCT g.year FROM Goal g WHERE g.year IS NOT NULL ORDER BY g.year")
    List<Integer> findDistinctYears();
}
