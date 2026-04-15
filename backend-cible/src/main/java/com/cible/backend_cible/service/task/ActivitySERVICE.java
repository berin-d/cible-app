package com.cible.backend_cible.service.task;

import com.cible.backend_cible.db.task.ActivityRepository;
import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitySERVICE {
    
    @Autowired
    private ActivityRepository activityRepository;

        public Iterable<Activity> getAllActivities(){
            return activityRepository.findAll();
        }

        public Optional<Activity> getActivityById(Integer id){
            return activityRepository.findById(id);
        }

        public List<Activity> getActivitiesByUser(User user) {
            return activityRepository.findByUser(user);
        }
    
        public List<Activity> getActivitiesByUserId(Integer userId) {
            return activityRepository.findByUser_Id(userId);
        }

        public Activity createActivity(Activity activity){
            return activityRepository.save(activity);
        }

        
    public Optional<Activity> updateActivity(Integer id, Activity newData) {

        return activityRepository.findById(id).map(existing -> {

            existing.setUser(newData.getUser());
            existing.setAction(newData.getAction());
            existing.setEntityType(newData.getEntityType());
            existing.setEntityId(newData.getEntityId());

            return activityRepository.save(existing);
        });
    }

    public boolean deleteActivity(Integer id) {

        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

