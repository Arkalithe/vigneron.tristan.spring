package fr.humanbooster.vignerontristan.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.vignerontristan.jsonviews.MapJsonview;
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
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView( MapJsonview.MapCommonView.class)
    private Long id;

    @NotBlank
    @JsonView( MapJsonview.MapCommonView.class)
    private String name;

    @NotNull
    @JsonView( MapJsonview.MapShowView.class)
    private LocalDateTime createdAt;


}