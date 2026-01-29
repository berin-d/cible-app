package com.cible.backend_cible.mapper.task;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.cible.backend_cible.model.dtos.task.ReminderDTO;
import com.cible.backend_cible.model.task.Reminder;
import com.cible.backend_cible.model.task.Task;
import static org.assertj.core.api.Assertions.assertThat;

public class ReminderMapperTest {

    private final ReminderMapper mapper = ReminderMapper.INSTANCE;

    @Test
    void shouldMapEntityToDto() {
        Task task = new Task();
        task.setId(10);

        Reminder reminder = new Reminder();
        reminder.setId(1);
        reminder.setTask(task);
        reminder.setRemindAt(LocalDateTime.of(2026, 1, 26, 14, 30));

        ReminderDTO dto = mapper.toDto(reminder);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getTaskId()).isEqualTo(10);
        assertThat(dto.getRemindAt()).isEqualTo(LocalDateTime.of(2026, 1, 26, 14, 30));
    }

    @Test
    void shouldMapDtoToEntity() {
        ReminderDTO dto = new ReminderDTO();
        dto.setId(2);
        dto.setTaskId(20);
        dto.setRemindAt(LocalDateTime.of(2026, 2, 1, 9, 0));

        Reminder reminder = mapper.toEntity(dto);

        assertThat(reminder).isNotNull();
        assertThat(reminder.getId()).isEqualTo(2);
        assertThat(reminder.getRemindAt()).isEqualTo(LocalDateTime.of(2026, 2, 1, 9, 0));
        assertThat(reminder.getTask()).isNull();
    }
}