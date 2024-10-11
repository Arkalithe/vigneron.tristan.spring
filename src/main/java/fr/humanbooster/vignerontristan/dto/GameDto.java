package fr.humanbooster.vignerontristan.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class GameDto {

    private Boolean hasPan;

    private Boolean hasZoom;

    private Boolean hasMove;

    private Integer maximumTime;

    private Integer round;

    private Long mapId;

    private String userId;





}
