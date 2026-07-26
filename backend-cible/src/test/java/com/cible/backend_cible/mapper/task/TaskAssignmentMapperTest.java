package com.cible.backend_cible.mapper.task;

import com.cible.backend_cible.model.dtos.task.TaskAssignmentDTO;
import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.TaskAssignment;
import com.cible.backend_cible.model.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskAssignmentMapperTest {

    private final TaskAssignmentMapper mapper = TaskAssignmentMapper.INSTANCE;

    @Test
    void shouldMapEntityToDto() {
        User user = new User();
        user.setId(1);
        user.setUsername("alice");

        User assignedBy = new User();
        assignedBy.setId(2);
        assignedBy.setUsername("bob");

        Task task = new Task();
        task.setId(10);
        task.setTitle("Finish report");

        TaskAssignment assignment = new TaskAssignment();
        assignment.setId(100);
        assignment.setTask(task);
        assignment.setUser(user);
        assignment.setAssignedBy(assignedBy);
        assignment.setAssignedAt(LocalDateTime.now());

        TaskAssignmentDTO dto = mapper.toDTO(assignment);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(100);
        assertThat(dto.getTaskId()).isEqualTo(10);
        assertThat(dto.getUserId()).isEqualTo(1);
        assertThat(dto.getUsername()).isEqualTo("alice");
        assertThat(dto.getAssignedById()).isEqualTo(2);
        assertThat(dto.getAssignedByName()).isEqualTo("bob");
    }

    @Test
    void shouldMapDtoToEntity() {
        TaskAssignmentDTO dto = new TaskAssignmentDTO();
        dto.setId(101);
        dto.setTaskId(11);
        dto.setUserId(3);
        dto.setUsername("charlie");
        dto.setAssignedById(4);
        dto.setAssignedByName("dave");

        TaskAssignment entity = mapper.toEntity(dto);

        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(101);
        assertThat(entity.getTask()).isNull();
        assertThat(entity.getUser()).isNull(); 
        assertThat(entity.getAssignedBy()).isNull(); 
        assertThat(entity.getAssignedAt()).isNull(); 
    }
}
