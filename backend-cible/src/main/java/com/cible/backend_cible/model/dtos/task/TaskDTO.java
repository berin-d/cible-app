package com.cible.backend_cible.model.dtos.task;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer taskGroupId; 
    private String taskGroupName; 

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime completedAt;
    private Integer taskOrder;
}
