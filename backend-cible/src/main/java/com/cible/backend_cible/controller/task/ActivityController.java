
package com.cible.backend_cible.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<Iterable<Activity>> getAllActivities() {
        return ResponseEntity.ok(activitySERVICE.getAllActivities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Integer id) {

        return activitySERVICE.getActivityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Iterable<Activity>> getActivitiesByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(activitySERVICE.getActivitiesByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {

        Activity created = activitySERVICE.createActivity(activity);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Integer id,
                                                   @RequestBody Activity activity) {

        return activitySERVICE.updateActivity(id, activity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Integer id) {

        if (activitySERVICE.deleteActivity(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    
}