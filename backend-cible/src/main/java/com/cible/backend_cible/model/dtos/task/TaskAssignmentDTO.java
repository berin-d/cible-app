package com.cible.backend_cible.model.dtos.task;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskAssignmentDTO {

    private Integer id;

    private Integer taskId;          
    private Integer userId;     
    private String username;      
    private Integer assignedById;   
    private String assignedByName;
    private LocalDateTime assignedAt;
}