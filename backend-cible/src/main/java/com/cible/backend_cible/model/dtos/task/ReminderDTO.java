package com.cible.backend_cible.model.dtos.task;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderDTO {

    private Integer id;

    private Integer taskId;

    private LocalDateTime remindAt;
}
