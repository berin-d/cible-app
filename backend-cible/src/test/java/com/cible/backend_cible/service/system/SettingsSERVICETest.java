package com.cible.backend_cible.service.system;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cible.backend_cible.db.system.SettingsDB;
import com.cible.backend_cible.model.system.Settings;

@ExtendWith(MockitoExtension.class)
public class SettingsSERVICETest {

    @Mock
    private SettingsDB settingsDB;

    @InjectMocks
    private SettingsSERVICE settingsSERVICE;

    @Test
    void testGetAllSettings() {
        Settings s1 = new Settings();
        Settings s2 = new Settings();

        when(settingsDB.findAll()).thenReturn(List.of(s1, s2));

        Iterable<Settings> settings = settingsSERVICE.getAllSettings();

        assertNotNull(settings);
        verify(settingsDB, times(1)).findAll();
    }
}
