package com.cible.backend_cible.model.goal;

import com.cible.backend_cible.model.task.Task;
import com.cible.backend_cible.model.task.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "task_groups")
public class Goal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Group name is mandatory")
    @Column(nullable = false, length = 100)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user; // owner of group

    @OneToMany(mappedBy = "goal")
    private List<Task> tasks = new ArrayList<>();
}
