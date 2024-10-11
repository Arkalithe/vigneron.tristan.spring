package fr.humanbooster.vignerontristan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer points;

    private Integer time;

    private Long distance;
    @NotNull
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn
    private Game game;
    
    @ManyToOne
    @JoinColumn
    private Coordinate selected;

    @ManyToOne
    @JoinColumn
    private Coordinate origin;


}