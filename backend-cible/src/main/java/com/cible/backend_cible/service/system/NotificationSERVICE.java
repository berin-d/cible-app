package com.cible.backend_cible.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.system.NotificationRepository;
import com.cible.backend_cible.model.system.Notification;
import com.cible.backend_cible.model.task.User;

@Service
public class NotificationSERVICE {
    

    @Autowired
    private NotificationRepository notificationRepository;

    public Iterable<Notification> getAllNotifications(){
        return notificationRepository.findAll();
    }

        public List<Notification> getNotificationsByUser(User user) {
            return notificationRepository.findByUser(user);
        }
    
}
