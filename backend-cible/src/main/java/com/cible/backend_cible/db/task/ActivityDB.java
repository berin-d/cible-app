package com.cible.backend_cible.db.task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.model.task.User;

@Repository
public interface ActivityDB extends CrudRepository<Activity, Integer> {

    List<Activity> findByUser(User user);

    List<Activity> findByUser_Id(Integer userId);
    
}
