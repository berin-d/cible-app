package com.cible.backend_cible.model.dtos.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO {

    private Integer id;
    private String name;
    private String color;
    private Integer displayOrder;
}