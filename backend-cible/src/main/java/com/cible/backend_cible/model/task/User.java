package com.cible.backend_cible.model.task;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The username is mandatory")
    @Size(min = 3, max = 30, message = "The username must contains between 3 and 30 caracters")
    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @NotBlank(message = "The mail is mandatory")
    @Email(message = "format mail invalid")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "The password name is mandatory")
    @Size(min = 8, message = "The password must contains at least 8 caracters")
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @NotNull(message = "The role is mandatory")
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull(message = "the state active must be defined")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @NotNull(message = "The email verification status must be defined")
    @Column(name = "email_verified", nullable = false)
    private Boolean emailVerified; // after the signup, we receive a mail to confirm

    @NotNull(message = "The account lock status must be defined")
    @Column(name = "account_locked", nullable = false)
    private Boolean accountLocked; // if the limits of attemps is depassed, then false and so close the access to account.

    @NotNull(message = "The number of login attempts must be defined")
    @Min(value = 0, message = "The number of failed attempts cannot be negative")
    @Column(name = "failed_login_attempts", nullable = false)
    private Integer failedLoginAttempts; // number of attempts done

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt; 

    @Column(name = "password_updated_at")
    private LocalDateTime passwordUpdatedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // date of the creation of the account

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt; // date of the last update of the account


    @PrePersist
    protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
    }
}
