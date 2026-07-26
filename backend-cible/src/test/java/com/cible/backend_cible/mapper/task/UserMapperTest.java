package com.cible.backend_cible.mapper.task;

import com.cible.backend_cible.model.dtos.task.UserDTO;
import com.cible.backend_cible.model.task.Role;
import com.cible.backend_cible.model.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {
        
    @Test
    public void testUserToUserDTO() {
        User user = new User();
        user.setId(1);
        user.setUsername("matth");
        user.setEmail("matth@example.com");
        user.setRole(Role.ADMIN);
        user.setIsActive(true);
        user.setAccountLocked(false);
        user.setCreatedAt(LocalDateTime.now());

        UserDTO dto = UserMapper.INSTANCE.toDTO(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getEmail(), dto.getEmail());
        assertEquals(user.getRole(), dto.getRole());
        assertEquals(user.getIsActive(), dto.getIsActive());
        assertEquals(user.getAccountLocked(), dto.getAccountLocked());
        assertEquals(user.getCreatedAt(), dto.getCreatedAt());
    }

}
