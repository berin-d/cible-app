package com.cible.backend_cible.mapper.task;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.cible.backend_cible.model.dtos.task.StatusDTO;
import com.cible.backend_cible.model.task.Status;

public class StatusMapperTest {

    private final StatusMapper mapper = StatusMapper.INSTANCE;

    @Test
    void shouldMapEntityToDto() {
        Status status = new Status();
        status.setId(1);
        status.setName("IN_PROGRESS");
        status.setColor("#FFFF00");
        status.setDisplayOrder(2);

        StatusDTO dto = mapper.toDto(status);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getName()).isEqualTo("IN_PROGRESS");
        assertThat(dto.getColor()).isEqualTo("#FFFF00");
        assertThat(dto.getDisplayOrder()).isEqualTo(2);
    }

    @Test
    void shouldMapDtoToEntity() {
        StatusDTO dto = new StatusDTO();
        dto.setId(2);
        dto.setName("DONE");
        dto.setColor("#00FF00");
        dto.setDisplayOrder(1);

        Status status = mapper.toEntity(dto);

        assertThat(status).isNotNull();
        assertThat(status.getId()).isEqualTo(2);
        assertThat(status.getName()).isEqualTo("DONE");
        assertThat(status.getColor()).isEqualTo("#00FF00");
        assertThat(status.getDisplayOrder()).isEqualTo(1);
    }
}
