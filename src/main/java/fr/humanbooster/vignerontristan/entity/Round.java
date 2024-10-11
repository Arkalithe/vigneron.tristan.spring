package fr.humanbooster.vignerontristan.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.vignerontristan.jsonviews.GameJsonview;
import fr.humanbooster.vignerontristan.jsonviews.RoundJsonview;
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
    @JsonView( RoundJsonview.RoundShowView.class)
    private Long id;

    @JsonView({GameJsonview.GameShowView.class, RoundJsonview.RoundShowView.class})
    private Integer points;

    @JsonView({GameJsonview.GameShowView.class, RoundJsonview.RoundShowView.class})
    private Integer time;

    @JsonView({GameJsonview.GameShowView.class, RoundJsonview.RoundShowView.class})
    private Long distance;

    @NotNull
    @JsonView( RoundJsonview.RoundShowView.class)
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