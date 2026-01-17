package com.cible.backend_cible.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "settings")
public class Settings {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    @NotNull(message = "User is mandatory")
    private Users user;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Theme theme = Theme.LIGHT;
    
    @NotNull(message = "Notifications enabled status is mandatory")
    @Column(name = "notifications_enabled", nullable = false)
    private Boolean notificationsEnabled = true;
    
    @NotNull(message = "Email notifications status is mandatory")
    @Column(name = "email_notifications", nullable = false)
    private Boolean emailNotifications = true;
    
    @NotNull(message = "Desktop notifications status is mandatory")
    @Column(name = "desktop_notifications", nullable = false)
    private Boolean desktopNotifications = true;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language = Language.FR;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "date_format")
    private DateFormat dateFormat = DateFormat.DD_MM_YYYY;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "time_format")
    private TimeFormat timeFormat = TimeFormat.HOURS_24;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "default_view")
    private ViewType defaultView = ViewType.LIST;
    
    @Column(name = "tasks_per_page")
    private Integer tasksPerPage = 20;
    
    @NotNull(message = "Sound enabled status is mandatory")
    @Column(name = "sound_enabled", nullable = false)
    private Boolean soundEnabled = true;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

// Enums associés
enum Theme {
    LIGHT, DARK, AUTO
}

enum Language {
    FR, EN, ES, DE, IT
}

enum DateFormat {
    DD_MM_YYYY, MM_DD_YYYY, YYYY_MM_DD
}

enum TimeFormat {
    HOURS_12, HOURS_24
}

enum ViewType {
    LIST, GRID, CALENDAR, KANBAN
}