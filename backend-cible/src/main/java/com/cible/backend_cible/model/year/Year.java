package com.cible.backend_cible.model.year;

import com.cible.backend_cible.model.user.User;
import jakarta.persistence.*;
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

    @Column(name = "year")
    private String year;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}