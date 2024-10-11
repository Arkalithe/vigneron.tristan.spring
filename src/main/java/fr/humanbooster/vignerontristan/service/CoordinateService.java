package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.dto.GameDto;
import fr.humanbooster.vignerontristan.entity.Game;
import fr.humanbooster.vignerontristan.repository.CoordinateRepository;
import fr.humanbooster.vignerontristan.entity.Coordinate;
import fr.humanbooster.vignerontristan.dto.CoordinateDto;
import fr.humanbooster.vignerontristan.service.interfaces.ServiceInterfaceBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
@AllArgsConstructor
public class CoordinateService implements ServiceInterfaceBase<Coordinate, CoordinateDto>{

    private final CoordinateRepository coordinateRepository;
    @Override
    public Coordinate create(CoordinateDto coordinateDto) {
        return coordinateRepository.saveAndFlush(objectFromDto(new Coordinate(), coordinateDto));
    }
    @Override
    public List<Coordinate> list() {
        return coordinateRepository.findAll();
    }

    private Coordinate objectFromDto(Coordinate coordinate, CoordinateDto coordinateDto) {

        coordinate.setLatitude(coordinateDto.getLatitude());
        coordinate.setLongitude(coordinateDto.getLongitude());
        return coordinate;
    }
}
