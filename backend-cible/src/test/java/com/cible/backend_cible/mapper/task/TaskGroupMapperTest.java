package com.cible.backend_cible.mapper.task;

import org.junit.jupiter.api.Test;

import com.cible.backend_cible.model.dtos.task.TaskGroupDTO;
import com.cible.backend_cible.model.task.TaskGroup;
import com.cible.backend_cible.model.task.User;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskGroupMapperTest {

    private final TaskGroupMapper mapper = TaskGroupMapper.INSTANCE;


    @Test
    void shouldMapTaskGroupToDto() {
        User user = new User();
        user.setId(1);

        TaskGroup group = new TaskGroup();
        group.setId(10);
        group.setName("Travail");
        group.setUserId(user.getId());

        TaskGroupDTO dto = mapper.toDTO(group);

        assertThat(dto.getId()).isEqualTo(10);
        assertThat(dto.getName()).isEqualTo("Travail");
        assertThat(dto.getUserId()).isEqualTo(1);
    }
}
