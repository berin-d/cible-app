package com.cible.backend_cible.model.dtos.task;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskGroupDTO {
    
    private Integer id;
    private String name;
    private Integer userId;
    private List<TaskDTO> tasks;
}
