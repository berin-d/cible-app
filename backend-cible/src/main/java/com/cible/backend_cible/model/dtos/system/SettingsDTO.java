package com.cible.backend_cible.model.dtos.system;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingsDTO {

    private Integer id;
    private Integer userId;
    private String theme;
    private Boolean notificationsEnabled;
    private Boolean emailNotifications;
    private Boolean desktopNotifications;
    private String language;
    private String dateFormat;
    private String timeFormat;
    private String defaultView;
    private Integer tasksPerPage;
    private Boolean soundEnabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
