package fr.humanbooster.vignerontristan.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.vignerontristan.jsonviews.CoordinateJsonview;
import fr.humanbooster.vignerontristan.jsonviews.RoundJsonview;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView( CoordinateJsonview.CoordinateShowView.class)
    private Long id;

    @NotBlank
    @JsonView( CoordinateJsonview.CoordinateShowView.class)
    private String latitude;

    @NotBlank
    @JsonView( CoordinateJsonview.CoordinateShowView.class)
    private String longitude;
}