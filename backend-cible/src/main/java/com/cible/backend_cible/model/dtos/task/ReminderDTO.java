package com.cible.backend_cible.model.dtos.task;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReminderDTO {

    private Integer id;

    private Integer taskId;

    private LocalDateTime remindAt;
}
