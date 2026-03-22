package com.cible.backend_cible.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cible.backend_cible.db.system.SettingsRepository;
import com.cible.backend_cible.model.system.Settings;
import com.cible.backend_cible.model.task.User;

@Service
public class SettingsSERVICE {
 
   @Autowired
    private SettingsRepository settingsRepository;

    public Iterable<Settings> getAllSettings(){
        return settingsRepository.findAll();
    }

        public List<Settings> getSettingsByUser(User user) {
            return settingsRepository.findByUser(user);
        }


}
