package fr.humanbooster.vignerontristan.controller;

import fr.humanbooster.vignerontristan.dto.GameDto;
import fr.humanbooster.vignerontristan.dto.MapDto;
import fr.humanbooster.vignerontristan.entity.Game;
import fr.humanbooster.vignerontristan.entity.Map;
import fr.humanbooster.vignerontristan.service.MapService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maps")
@AllArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping()
    public List<Map> getGameAll() {
        return mapService.list();
    }

    @GetMapping("/{id}")
    public Map getGameById(@PathVariable Long id) {
        return mapService.findById(id);
    }

    @PostMapping
    public Map createGame(@Valid @RequestBody MapDto mapDto) {
        return mapService.create(mapDto);
    }

}
