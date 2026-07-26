package com.cible.backend_cible.mapper.task;

import com.cible.backend_cible.model.dtos.task.ActivityDTO;
import com.cible.backend_cible.model.task.Activity;
import com.cible.backend_cible.model.user.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
public class ActivityMapperTest {

    private final ActivityMapper mapper = Mappers.getMapper(ActivityMapper.class);

    @Test
    void shouldMapEntityToDto() {
        User user = new User();
        user.setId(5);

        Activity activity = new Activity();
        activity.setId(10);
        activity.setUser(user);
        activity.setAction("CREATED");
        activity.setEntityType("TASK");
        activity.setEntityId(99);
        activity.setCreatedAt(LocalDateTime.now());

        ActivityDTO dto = mapper.toDto(activity);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(10);
        assertThat(dto.getUserId()).isEqualTo(5);
        assertThat(dto.getAction()).isEqualTo("CREATED");
        assertThat(dto.getEntityType()).isEqualTo("TASK");
        assertThat(dto.getEntityId()).isEqualTo(99);
        assertThat(dto.getCreatedAt()).isEqualTo(activity.getCreatedAt());
    }

    @Test
    void shouldMapDtoToEntity() {
        ActivityDTO dto = new ActivityDTO();
        dto.setId(20);
        dto.setUserId(7);
        dto.setAction("UPDATED");
        dto.setEntityType("COMMENT");
        dto.setEntityId(44);

        Activity entity = mapper.toEntity(dto);

        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(20);
        assertThat(entity.getAction()).isEqualTo("UPDATED");
        assertThat(entity.getEntityType()).isEqualTo("COMMENT");
        assertThat(entity.getEntityId()).isEqualTo(44);

        assertThat(entity.getUser()).isNull();
        assertThat(entity.getCreatedAt()).isNull();
    }
}