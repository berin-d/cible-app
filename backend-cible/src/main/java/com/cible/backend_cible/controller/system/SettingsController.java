package com.cible.backend_cible.controller.system;

import com.cible.backend_cible.model.system.Settings;
import com.cible.backend_cible.service.system.SettingsSERVICE;
import com.cible.backend_cible.service.user.UserSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    @Autowired
    private SettingsSERVICE settingsSERVICE;

    @Autowired
    private UserSERVICE userSERVICE;

    @GetMapping("/all")
    public Iterable<Settings> getAllSettings() {
        return settingsSERVICE.getAllSettings();
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Settings>> getSettingsByUser(@PathVariable Integer userId) {
        return userSERVICE.getUserById(userId)
                .map(user -> ResponseEntity.ok(settingsSERVICE.getSettingsByUser(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
