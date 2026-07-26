package com.cible.backend_cible.db.task;

import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

    List<Activity> findByUser(User user);

    List<Activity> findByUser_Id(Integer userId);
    
}
