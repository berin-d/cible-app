package com.cible.backend_cible.model;


import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Users {


    @NotNull(message = "The id can not be null")
    private Integer id;

    @NotBlank(message = "The username is mandatory")
    @Size(min = 3, max = 30, message = "The username must contains between 3 and 30 caracters")
    private String username;

    @NotBlank(message = "The mail is mandatory")
    @Email(message = "format mail invalid")
    private String email;

    @NotBlank(message = "The password name is mandatory")
    @Size(min = 8, message = "The password must contains at least 8 caracters")
    private String password_hash;

    @NotNull(message = "The role is mandatory")
    private Role role;

    @NotNull(message = "the state active must be defined")
    private Boolean is_active;

    @NotNull(message = "The email verification status must be defined")
    private Boolean email_verified; // after the signup, we receive a mail to confirm

    @NotNull(message = "The account lock status must be defined")
    private Boolean account_locked; // if the limits of attemps is depassed, then false and so close the access to account.

    @NotNull(message = "The number of login attempts must be defined")
    @Min(value = 0, message = "The number of failed attempts cannot be negative")
    private Integer failed_login_attempts; // number of attempts done

    private LocalDateTime last_login_at; 

    private LocalDateTime password_updated_at;

    @NotNull(message = "The creation date is mandatory")
    private LocalDateTime created_at; // date of the creation of the account

    @NotNull(message = "The update date is mandatory")
    private LocalDateTime updated_at; // date of the last update of the account
}
