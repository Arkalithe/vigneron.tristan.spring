package fr.humanbooster.vignerontristan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotNull
    private Integer maximumTime;
    @NotNull
    private Boolean hasMove;
    @NotNull
    private Boolean hasPan;
    @NotNull
    private Boolean hasZoom;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Integer nbRounds;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Map map;

    @OneToMany(mappedBy = "game")
    private List<Round> round = new ArrayList<>();

    public Integer getTotalPoint() {

       // getRound().stream().map((item) -> item.getPoints());
        return 0;
    }

}