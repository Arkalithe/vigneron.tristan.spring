package fr.humanbooster.vignerontristan.controller;

import fr.humanbooster.vignerontristan.dto.GameDto;
import fr.humanbooster.vignerontristan.entity.Game;
import fr.humanbooster.vignerontristan.service.GameService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/game")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping()
    public List<Game> getGameAll() {
        return gameService.list();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable String id) {
        return gameService.findById(id);
    }

    @PostMapping
    public Game createGame(@Valid @RequestBody GameDto gameDto) {
        return gameService.create(gameDto);
    }


}
