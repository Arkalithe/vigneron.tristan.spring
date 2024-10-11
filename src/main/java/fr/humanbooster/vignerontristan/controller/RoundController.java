package fr.humanbooster.vignerontristan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.humanbooster.vignerontristan.dto.MapDto;
import fr.humanbooster.vignerontristan.dto.RoundDto;
import fr.humanbooster.vignerontristan.entity.Map;
import fr.humanbooster.vignerontristan.entity.Round;
import fr.humanbooster.vignerontristan.jsonviews.GameJsonview;
import fr.humanbooster.vignerontristan.jsonviews.RoundJsonview;
import fr.humanbooster.vignerontristan.service.RoundService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rounds")
@AllArgsConstructor
public class RoundController {

    private final RoundService roundService;


    @PostMapping
    @JsonView( RoundJsonview.RoundShowView.class)
    public Round createGame(@Valid @RequestBody RoundDto roundDto) {
        return roundService.create(roundDto);
    }
}
