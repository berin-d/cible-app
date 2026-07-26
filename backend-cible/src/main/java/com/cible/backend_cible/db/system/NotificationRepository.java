package com.cible.backend_cible.db.system;

import com.cible.backend_cible.model.system.Notification;
import com.cible.backend_cible.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {

    List<Notification> findByUser(User user);    
    
}
