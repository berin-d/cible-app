package com.cible.backend_cible.mapper.task;

import com.cible.backend_cible.model.dtos.task.TaskDTO;
import com.cible.backend_cible.model.goal.Goal;
import com.cible.backend_cible.model.task.Priority;
import com.cible.backend_cible.model.task.Status;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMapperTest {

    @Test
    void testToDtoAndToEntity() {
        User user = new User();
        user.setId(1);
        user.setUsername("matth");

        Status status = new Status();
        status.setId(10);
        status.setName("IN_PROGRESS");

        Priority priority = new Priority();
        priority.setId(5);
        priority.setName("HIGH");

        Goal group = new Goal();
        group.setId(3);
        group.setName("Travail");

        Task task = new Task();
        task.setId(100);
        task.setTitle("Faire le mapping");
        task.setDescription("Tester MapStruct avec Task");
        task.setUser(user);
        task.setStatus(status);
        task.setPriority(priority);
        task.setGoal(group);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        TaskDTO dto = TaskMapper.INSTANCE.toDto(task);
        assertNotNull(dto);
        assertEquals(100, dto.getId());
        assertEquals("matth", dto.getUsername());
        assertEquals(1, dto.getUserId());
        assertEquals(10, dto.getStatusId());
        assertEquals("IN_PROGRESS", dto.getStatusName());
        assertEquals(5, dto.getPriorityId());
        assertEquals("HIGH", dto.getPriorityName());
        assertEquals(3, dto.getGoalId());
        assertEquals("Travail", dto.getGoalName());

        Task entity = TaskMapper.INSTANCE.toEntity(dto);
        assertNotNull(entity);
        assertNull(entity.getUser());
        assertNull(entity.getStatus());
        assertNull(entity.getPriority());
        assertNull(entity.getGoal());
    }
}
