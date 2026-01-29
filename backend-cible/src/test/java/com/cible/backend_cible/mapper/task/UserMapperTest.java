package com.cible.backend_cible.mapper.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import com.cible.backend_cible.model.dtos.task.UserDTO;
import com.cible.backend_cible.model.task.Role;
import com.cible.backend_cible.model.task.User;

public class UserMapperTest {
        
    @Test
    public void testUserToUserDTO() {
        User user = new User();
        user.setId(1);
        user.setUsername("matth");
        user.setEmail("matth@example.com");
        user.setRole(Role.ADMIN);
        user.setIsActive(true);
        user.setEmailVerified(true);
        user.setAccountLocked(false);
        user.setCreatedAt(LocalDateTime.now());

        UserDTO dto = UserMapper.INSTANCE.toDTO(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getEmail(), dto.getEmail());
        assertEquals(user.getRole(), dto.getRole());
        assertEquals(user.getIsActive(), dto.getIsActive());
        assertEquals(user.getEmailVerified(), dto.getEmailVerified());
        assertEquals(user.getAccountLocked(), dto.getAccountLocked());
        assertEquals(user.getCreatedAt(), dto.getCreatedAt());
    }

}
