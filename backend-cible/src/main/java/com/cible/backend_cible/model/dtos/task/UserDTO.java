package com.cible.backend_cible.model.dtos.task;

import java.time.LocalDateTime;

import com.cible.backend_cible.model.task.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private Boolean isActive;
    private Boolean emailVerified;
    private Boolean accountLocked;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;
}
