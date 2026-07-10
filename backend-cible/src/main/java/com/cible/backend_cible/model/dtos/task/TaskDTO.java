package com.cible.backend_cible.model.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Integer id;
    private String title;
    private String description;
    private LocalDateTime dueDate;

    private Integer userId; 
    private String username;
    private Integer statusId;
    private String statusName;
    private Integer priorityId;
    private String priorityName;
    private Integer goalId;
    private String goalName;
    private Boolean isCompleted;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime completedAt;
    private Integer taskOrder;
}
