package fr.humanbooster.vignerontristan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    private String avatar;
    @NotNull
    private LocalDate birthedAt;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Integer level = 1;
    @NotBlank
    private String roles = "ROLE_USER";

    @OneToMany(mappedBy = "user")
    private List<Game> game = new ArrayList<>();

    private Boolean getIsAdmin() {
        return roles.contains("ROLE_ADMIN");
    }

}