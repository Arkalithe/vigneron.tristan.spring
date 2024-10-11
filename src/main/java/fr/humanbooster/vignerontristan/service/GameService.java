package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.entity.Map;
import fr.humanbooster.vignerontristan.entity.Round;
import fr.humanbooster.vignerontristan.entity.User;
import fr.humanbooster.vignerontristan.repository.GameRepository;
import fr.humanbooster.vignerontristan.entity.Game;
import fr.humanbooster.vignerontristan.dto.GameDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final MapService mapService;
    private final UserService userService;


    public Game create(GameDto gameDto) {
        return gameRepository.saveAndFlush(objectFromDto(new Game(), gameDto));
    }


    public Game findById(String id) {
        return gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public List<Game> list() {
        return gameRepository.findAll();
    }

    private Game objectFromDto(Game game, GameDto gameDto) {
        Map map = mapService.findById(gameDto.getMapId());
        User user = userService.findById(gameDto.getUserId());
        game.setHasMove(gameDto.getHasMove());
        game.setHasPan(gameDto.getHasPan());
        game.setHasZoom(gameDto.getHasZoom());
        game.setMaximumTime(gameDto.getMaximumTime());
        game.setNbRounds(gameDto.getRound());
        game.setMap(map);
        game.setUser(user);
        game.setCreatedAt(LocalDateTime.now());
        return game;
    }
}
