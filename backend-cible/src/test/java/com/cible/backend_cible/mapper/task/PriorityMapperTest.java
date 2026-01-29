package com.cible.backend_cible.mapper.task;

import org.junit.jupiter.api.Test;

import com.cible.backend_cible.model.dtos.task.PriorityDTO;
import com.cible.backend_cible.model.task.Priority;
import static org.assertj.core.api.Assertions.assertThat;

public class PriorityMapperTest {

    private final PriorityMapper mapper = PriorityMapper.INSTANCE;

    @Test
    void shouldMapEntityToDto() {
        Priority priority = new Priority();
        priority.setId(1);
        priority.setName("HIGH");
        priority.setColor("#FF0000");

        PriorityDTO dto = mapper.toDto(priority);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getName()).isEqualTo("HIGH");
        assertThat(dto.getColor()).isEqualTo("#FF0000");
    }

    @Test
    void shouldMapDtoToEntity() {
        PriorityDTO dto = new PriorityDTO();
        dto.setId(2);
        dto.setName("LOW");
        dto.setColor("#00FF00");

        Priority priority = mapper.toEntity(dto);

        assertThat(priority).isNotNull();
        assertThat(priority.getId()).isEqualTo(2);
        assertThat(priority.getName()).isEqualTo("LOW");
        assertThat(priority.getColor()).isEqualTo("#00FF00");
    }
}