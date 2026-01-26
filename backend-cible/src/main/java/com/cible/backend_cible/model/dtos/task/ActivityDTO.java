package com.cible.backend_cible.model.dtos.task;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {

    private Integer id;
    private Integer userId;
    private String action;
    private String entityType;
    private Integer entityId;
    private LocalDateTime createdAt;
}