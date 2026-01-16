package com.cible.backend_cible.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Users {


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
    private String password_hash;

    @NotNull(message = "The role is mandatory")
    @Column(nullable = false, length = 20)
    private Role role;

    @NotNull(message = "the state active must be defined")
    @Column(name = "is_active", nullable = false)
    private Boolean is_active;

    @NotNull(message = "The email verification status must be defined")
    @Column(name = "email_verified", nullable = false)
    private Boolean email_verified; // after the signup, we receive a mail to confirm

    @NotNull(message = "The account lock status must be defined")
    @Column(name = "account_locked", nullable = false)
    private Boolean account_locked; // if the limits of attemps is depassed, then false and so close the access to account.

    @NotNull(message = "The number of login attempts must be defined")
    @Min(value = 0, message = "The number of failed attempts cannot be negative")
    @Column(name = "failed_login_attempts", nullable = false)
    private Integer failed_login_attempts; // number of attempts done

    @Column(name = "last_login_at")
    private LocalDateTime last_login_at; 

    @Column(name = "password_updated_at")
    private LocalDateTime password_updated_at;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at; // date of the creation of the account

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updated_at; // date of the last update of the account
}
