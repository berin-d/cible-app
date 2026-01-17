package com.cible.backend_cible.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "priorities")
public class Priority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Priority name is mandatory")
    @Column(nullable = false, unique = true, length = 50)
    private String name; // LOW, MEDIUM, HIGH, URGENT
    
    @Column(length = 7)
    private String color; // #FF0000 pour urgent, etc.
}
