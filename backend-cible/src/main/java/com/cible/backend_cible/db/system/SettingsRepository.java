package com.cible.backend_cible.db.system;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cible.backend_cible.model.system.Settings;
import com.cible.backend_cible.model.task.User;

@Repository
public interface SettingsRepository extends CrudRepository<Settings, Integer> {

    List<Settings> findByUser(User user);
    
}