package com.cible.backend_cible.model.task;

import com.cible.backend_cible.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "activities")
public class Activity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user;
    
    @NotBlank(message = "Action is mandatory")
    @Column(nullable = false, length = 100)
    private String action; // CREATED, UPDATED, DELETED, COMPLETED
    
    @NotBlank(message = "Entity type is mandatory")
    @Column(name = "entity_type", nullable = false, length = 50)
    private String entityType; // TASK, COMMENT, USER
    
    @NotNull(message = "Entity ID is mandatory")
    @Column(name = "entity_id", nullable = false)
    private Integer entityId;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
