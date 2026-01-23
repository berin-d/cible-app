package com.cible.backend_cible.controller.system;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cible.backend_cible.model.system.Settings;
import com.cible.backend_cible.model.task.User;
import com.cible.backend_cible.service.system.SettingsSERVICE;
import com.cible.backend_cible.service.task.UserSERVICE;

@ExtendWith(MockitoExtension.class)
public class SettingsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SettingsSERVICE settingsSERVICE;

    @Mock
    private UserSERVICE userSERVICE;

    @InjectMocks
    private SettingsController settingsController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(settingsController).build();
    }

    @Test
    void testGetAllSettings() throws Exception {
        Settings s1 = new Settings();
        s1.setId(1);
        Settings s2 = new Settings();
        s2.setId(2);

        when(settingsSERVICE.getAllSettings()).thenReturn(List.of(s1, s2));

        mockMvc.perform(get("/api/settings/all")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void testGetSettingsByUser_Found() throws Exception {
        User user = new User();
        user.setId(1);
        Settings s1 = new Settings();
        s1.setId(10);
        Settings s2 = new Settings();
        s2.setId(20);

        when(userSERVICE.getUserById(1)).thenReturn(Optional.of(user));
        when(settingsSERVICE.getSettingsByUser(user)).thenReturn(List.of(s1, s2));

        mockMvc.perform(get("/api/settings/user/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(10))
            .andExpect(jsonPath("$[1].id").value(20));
    }

    @Test
    void testGetSettingsByUser_NotFound() throws Exception {
        when(userSERVICE.getUserById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/settings/user/999")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is4xxClientError()); 
}
}