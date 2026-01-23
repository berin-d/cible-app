
package com.cible.backend_cible.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.service.task.ActivitySERVICE;


@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivitySERVICE activitySERVICE;

    @GetMapping("/all")
    public Iterable<Activity> getAllActivities() {
        return activitySERVICE.getAllActivities();
    }

    @GetMapping("/{id}")
    public Iterable<Activity> getActivitiesById(@PathVariable Integer id) {
        return activitySERVICE.getActivitiesByUserId(id);
    }

    @PostMapping("/")
    public Activity createActivity(@RequestBody Activity activity) {
        return activitySERVICE.createActivity(activity);
    }

    @GetMapping("/user/{userId}")
    public Iterable<Activity> getActivitiesByUser(@PathVariable Integer userId) {
        return activitySERVICE.getActivitiesByUserId(userId);
    }
}