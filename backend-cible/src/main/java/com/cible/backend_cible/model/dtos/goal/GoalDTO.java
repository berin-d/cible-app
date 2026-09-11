package com.cible.backend_cible.model.dtos.goal;

import com.cible.backend_cible.model.dtos.task.TaskDTO;
import com.cible.backend_cible.model.year.Year;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalDTO {
    
    private Integer id;
    private String name;
    private Integer userId;
    private String year;
    private List<TaskDTO> tasks;

}
