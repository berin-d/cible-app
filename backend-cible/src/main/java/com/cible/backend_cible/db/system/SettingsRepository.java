package com.cible.backend_cible.db.system;

import com.cible.backend_cible.model.system.Settings;
import com.cible.backend_cible.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingsRepository extends CrudRepository<Settings, Integer> {

    List<Settings> findByUser(User user);
    
}