package com.cible.backend_cible.model.task;

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
@Table(name = "status")
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Status name is mandatory")
    @Column(nullable = false, unique = true, length = 50)
    private String name; // TODO, IN_PROGRESS, DONE, CANCELLED
    
    @Column(length = 7)
    private String color; 
    
    @Column(name = "display_order")
    private Integer displayOrder; // sort of displayed
}
