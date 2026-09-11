package com.cible.backend_cible.model.year;

import com.cible.backend_cible.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "years",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_year_user",
                columnNames = {"year", "user_id"}
        )
)
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Year value is mandatory")
    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "is_open")
    private Boolean isOpen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user;
}