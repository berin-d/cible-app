package com.cible.backend_cible.mapper.system;

import com.cible.backend_cible.model.dtos.system.NotificationDTO;
import com.cible.backend_cible.model.system.Notification;
import com.cible.backend_cible.model.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotificationMapperTest {

    private final NotificationMapper mapper = NotificationMapper.INSTANCE;

    @Test
    public void testToDto() {
        User user = new User();
        user.setId(1);
        user.setUsername("matth");
        
        Notification notification = new Notification();
        notification.setId(100);
        notification.setUser(user);
        notification.setMessage("Test notification");
        notification.setIsRead(false);
        notification.setCreatedAt(LocalDateTime.now());

        NotificationDTO dto = mapper.toDto(notification);

        assertNotNull(dto);
        assertEquals(100, dto.getId());
        assertEquals(1, dto.getUserId());
        assertEquals("Test notification", dto.getMessage());
        assertEquals(false, dto.getIsRead());
        assertEquals(notification.getCreatedAt(), dto.getCreatedAt());
    }

    @Test
    public void testToEntity() {
        NotificationDTO dto = new NotificationDTO();
        dto.setId(200);
        dto.setUserId(2);
        dto.setMessage("DTO notification");
        dto.setIsRead(true);
        dto.setCreatedAt(LocalDateTime.now());

        Notification notification = mapper.toEntity(dto);

        assertNotNull(notification);
        assertEquals(200, notification.getId());
        assertEquals(null, notification.getUser());
        assertEquals("DTO notification", notification.getMessage());
        assertEquals(true, notification.getIsRead());
        assertEquals(null, notification.getCreatedAt());
    }
}