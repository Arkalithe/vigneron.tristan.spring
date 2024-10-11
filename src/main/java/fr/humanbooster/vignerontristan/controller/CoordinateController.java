package fr.humanbooster.vignerontristan.controller;

import fr.humanbooster.vignerontristan.dto.CoordinateDto;
import fr.humanbooster.vignerontristan.dto.RoundDto;
import fr.humanbooster.vignerontristan.entity.Coordinate;
import fr.humanbooster.vignerontristan.entity.Round;
import fr.humanbooster.vignerontristan.service.CoordinateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coordinates")
@AllArgsConstructor
public class CoordinateController {

    private final CoordinateService coordinateService;

    @PostMapping
    public Coordinate createGame(@Valid @RequestBody CoordinateDto coordinateDto) {
        return coordinateService.create(coordinateDto);
    }

}
