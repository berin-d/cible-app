package com.cible.backend_cible.mapper.system;

import com.cible.backend_cible.model.dtos.system.SettingsDTO;
import com.cible.backend_cible.model.system.*;
import com.cible.backend_cible.model.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SettingsMapperTest {

    private final SettingsMapper mapper = SettingsMapper.INSTANCE;

    @Test
    public void testToDto() {
        User user = new User();
        user.setId(1);
        user.setUsername("matth");

        Settings settings = new Settings();
        settings.setId(10);
        settings.setUser(user);
        settings.setNotificationsEnabled(true);
        settings.setEmailNotifications(true);
        settings.setDesktopNotifications(false);
        settings.setTheme(Theme.DARK);
        settings.setLanguage(Language.EN);
        settings.setDateFormat(DateFormat.DD_MM_YYYY);
        settings.setTimeFormat(TimeFormat.HOURS_24);
        settings.setDefaultView(ViewType.LIST);
        settings.setTasksPerPage(20);
        settings.setSoundEnabled(true);
        settings.setCreatedAt(LocalDateTime.now());
        settings.setUpdatedAt(LocalDateTime.now());

        SettingsDTO dto = mapper.toDto(settings);

        assertNotNull(dto);
        assertEquals(10, dto.getId());
        assertEquals(1, dto.getUserId());
        assertEquals(true, dto.getNotificationsEnabled());
        assertEquals(false, dto.getDesktopNotifications());
        assertEquals("DARK", dto.getTheme());
        assertEquals("EN", dto.getLanguage());
        assertEquals("DD_MM_YYYY", dto.getDateFormat());
        assertEquals("HOURS_24", dto.getTimeFormat());
        assertEquals("LIST", dto.getDefaultView());
        assertEquals(20, dto.getTasksPerPage());
        assertEquals(true, dto.getSoundEnabled());
        assertEquals(settings.getCreatedAt(), dto.getCreatedAt());
        assertEquals(settings.getUpdatedAt(), dto.getUpdatedAt());
    }

    @Test
    public void testToEntity() {
        SettingsDTO dto = new SettingsDTO();
        dto.setId(20);
        dto.setUserId(2);
        dto.setNotificationsEnabled(false);
        dto.setEmailNotifications(false);
        dto.setDesktopNotifications(true);
        dto.setTheme("LIGHT");
        dto.setLanguage("FR");
        dto.setDateFormat("YYYY_MM_DD");
        dto.setTimeFormat("HOURS_12");
        dto.setDefaultView("GRID");
        dto.setTasksPerPage(50);
        dto.setSoundEnabled(false);
        dto.setCreatedAt(LocalDateTime.now());
        dto.setUpdatedAt(LocalDateTime.now());

        Settings settings = mapper.toEntity(dto);

        assertNotNull(settings);
        assertEquals(20, settings.getId());

        assertEquals(null, settings.getUser());
        assertEquals(false, settings.getNotificationsEnabled());
        assertEquals(false, settings.getEmailNotifications());
        assertEquals(true, settings.getDesktopNotifications());

        assertEquals(Theme.LIGHT, settings.getTheme());
        assertEquals(Language.FR, settings.getLanguage());
        assertEquals(DateFormat.YYYY_MM_DD, settings.getDateFormat());
        assertEquals(TimeFormat.HOURS_12, settings.getTimeFormat());
        assertEquals(ViewType.GRID, settings.getDefaultView());

        assertEquals(50, settings.getTasksPerPage());
        assertEquals(false, settings.getSoundEnabled());

        assertEquals(null, settings.getCreatedAt());
        assertEquals(null, settings.getUpdatedAt());
    }
}
