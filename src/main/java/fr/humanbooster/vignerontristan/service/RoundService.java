package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.entity.Coordinate;
import fr.humanbooster.vignerontristan.entity.Game;
import fr.humanbooster.vignerontristan.repository.CoordinateRepository;
import fr.humanbooster.vignerontristan.repository.RoundRepository;
import fr.humanbooster.vignerontristan.entity.Round;
import fr.humanbooster.vignerontristan.dto.RoundDto;

import fr.humanbooster.vignerontristan.service.interfaces.ServiceIdInterface;
import fr.humanbooster.vignerontristan.service.interfaces.ServiceInterfaceBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class RoundService implements ServiceInterfaceBase<Round, RoundDto>, ServiceIdInterface<Round, Long> {

    private final RoundRepository roundRepository;
    private final GameService gameService;
    private final CoordinateRepository coordinateRepository;

    @Override
    public Round create(RoundDto roundDto) {
        return roundRepository.saveAndFlush(objectFromDto(new Round(), roundDto));
    }

    @Override
    public Round findById(Long id) {
        return roundRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Round> list() {
        return roundRepository.findAll();
    }

    private Round objectFromDto(Round round, RoundDto roundDto) {
        Game game = gameService.findById(roundDto.getGameId());
        Random random = new Random();
        List<Coordinate> coordinates = coordinateRepository.findAll();
        Coordinate coordinate = coordinates.get(random.nextInt(0, (coordinates.size() - 1)));
        round.setGame(game);
        round.setCreatedAt(LocalDateTime.now());
        round.setOrigin(coordinate);
        return round;
    }

}
