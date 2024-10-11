package fr.humanbooster.vignerontristan.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
public class MapDto {

    @NotBlank
    private Long id;

    private String Name;
}
