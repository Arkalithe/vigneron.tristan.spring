package fr.humanbooster.vignerontristan.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.vignerontristan.jsonviews.GameJsonview;
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
    @JsonView( GameJsonview.GameListView.class)
    private String id;

    @NotNull
    @JsonView( GameJsonview.GameShowView.class)
    private Integer maximumTime;

    @NotNull
    @JsonView( GameJsonview.GameShowView.class)
    private Boolean hasMove;

    @NotNull
    @JsonView( GameJsonview.GameShowView.class)
    private Boolean hasPan;

    @NotNull
    @JsonView( GameJsonview.GameShowView.class)
    private Boolean hasZoom;

    @NotNull
    @JsonView( GameJsonview.GameCommonView.class)
    private LocalDateTime createdAt;

    @NotNull
    @JsonView( GameJsonview.GameCommonView.class)
    private Integer nbRounds;

    @ManyToOne
    @JoinColumn
    @JsonView( GameJsonview.GameListView.class)
    private User user;

    @ManyToOne
    @JoinColumn
    private Map map;

    @OneToMany(mappedBy = "game")
    @JsonView( GameJsonview.GameShowView.class)
    private List<Round> round = new ArrayList<>();

    @JsonView( GameJsonview.GameCommonView.class)
    public Integer getTotalPoint() {

       // getRound().stream().map((item) -> item.getPoints());
        return 0;
    }

}