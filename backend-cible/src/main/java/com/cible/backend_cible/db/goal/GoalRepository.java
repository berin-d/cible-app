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

    List<Goal> findByUser(User user);

    List<Goal> findByNameContainingIgnoreCase(String name);

    boolean existsByUserAndName(User user, String name);

    List<Goal> findByUser_Id(Integer userId);

    @Query("SELECT tg FROM Goal tg JOIN tg.tasks t WHERE YEAR(t.dueDate) = :year")
    List<Goal> findByYear(@Param("year") int year);



}
