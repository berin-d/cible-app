package com.cible.backend_cible.model.dtos.system;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

    private Integer id;
    private Integer userId;
    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt;
}