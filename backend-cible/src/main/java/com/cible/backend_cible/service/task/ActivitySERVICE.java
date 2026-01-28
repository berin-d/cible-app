package com.cible.backend_cible.service.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.task.ActivityDB;
import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.model.task.User;

@Service
public class ActivitySERVICE {
    
    @Autowired
    private ActivityDB activityDB;

        public Iterable<Activity> getAllActivities(){
            return activityDB.findAll();
        }

        public Optional<Activity> getActivityById(Integer id){
            return activityDB.findById(id);
        }

        public List<Activity> getActivitiesByUser(User user) {
            return activityDB.findByUser(user);
        }
    
        public List<Activity> getActivitiesByUserId(Integer userId) {
            return activityDB.findByUser_Id(userId);
        }

        public Activity createActivity(Activity activity){
            return activityDB.save(activity);
        }

        
    public Optional<Activity> updateActivity(Integer id, Activity newData) {

        return activityDB.findById(id).map(existing -> {

            existing.setUser(newData.getUser());
            existing.setAction(newData.getAction());
            existing.setEntityType(newData.getEntityType());
            existing.setEntityId(newData.getEntityId());

            return activityDB.save(existing);
        });
    }

    public boolean deleteActivity(Integer id) {

        if (activityDB.existsById(id)) {
            activityDB.deleteById(id);
            return true;
        }
        return false;
    }
}

