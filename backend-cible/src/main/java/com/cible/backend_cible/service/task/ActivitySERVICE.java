package com.cible.backend_cible.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.ActivityDB;
import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.model.task.User;

@Service
public class ActivitySERVICE {
    
    @Autowired
    private ActivityDB activityDB;

    public Iterable<Activity> getAllActivities(){
        return activityDB.findAll();
    }

        public List<Activity> getActivitiesByUser(User user) {
            return activityDB.findByUser(user);
        }
    
        public List<Activity> getActivitiesByUserId(Integer userId) {
            return activityDB.findByUser_Id(userId);
        }
    
}
