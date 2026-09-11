package com.cible.backend_cible.model.dtos.year;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YearDTO {
    private String year;
    private Integer userId;
    private Boolean isOpen;
}
