package com.cible.backend_cible.controller.system;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cible.backend_cible.model.system.Notification;
import com.cible.backend_cible.service.system.NotificationSERVICE;
import com.cible.backend_cible.service.task.UserSERVICE;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationSERVICE notificationSERVICE;

    @Autowired
    private UserSERVICE userSERVICE;

    @GetMapping("/all")
    public Iterable<Notification> getAllNotifications() {
        return notificationSERVICE.getAllNotifications();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getNotificationsByUser(@PathVariable Integer userId) {
        return userSERVICE.getUserById(userId)
                .map(user -> ResponseEntity.ok(notificationSERVICE.getNotificationsByUser(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}


