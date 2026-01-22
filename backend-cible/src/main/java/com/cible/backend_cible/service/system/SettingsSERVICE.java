package com.cible.backend_cible.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cible.backend_cible.db.system.SettingsDB;
import com.cible.backend_cible.model.system.Settings;
import com.cible.backend_cible.model.task.User;

public class SettingsSERVICE {
 
   @Autowired
    private SettingsDB settingsDB;

    public Iterable<Settings> getAllSettings(){
        return settingsDB.findAll();
    }

        public List<Settings> getSettingsByUser(User user) {
            return settingsDB.findByUser(user);
        }


}
