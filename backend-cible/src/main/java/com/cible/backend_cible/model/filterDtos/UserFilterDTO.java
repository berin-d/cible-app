package com.cible.backend_cible.model.filterDtos;

import com.cible.backend_cible.model.task.Role;

import lombok.Data;

@Data
public class UserFilterDTO {

    private String username;
    private String email;
    private Role role;
    private Boolean isActive;
    private Boolean emailVerified;
    private Boolean accountLocked;
    private Integer failedAttemptsGreaterThan;
}
