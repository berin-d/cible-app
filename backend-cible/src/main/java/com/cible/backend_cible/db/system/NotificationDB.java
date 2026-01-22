package com.cible.backend_cible.db.system;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.system.Notification;
import com.cible.backend_cible.model.task.User;

@Repository
public interface NotificationDB extends CrudRepository<Notification, Integer> {

    List<Notification> findByUser(User user);    
    
}
