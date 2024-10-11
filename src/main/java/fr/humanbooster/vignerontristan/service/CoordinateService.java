package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.repository.CoordinateRepository;
import fr.humanbooster.vignerontristan.entity.Coordinate;
import fr.humanbooster.vignerontristan.dto.CoordinateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
@AllArgsConstructor
public class CoordinateService {

    private final CoordinateRepository coordinateRepository;


    public Coordinate create(CoordinateDto coordinateDto) {
        return coordinateRepository.saveAndFlush(objectFromDto(new Coordinate(), coordinateDto));
    }


    public List<Coordinate> list() {
        return coordinateRepository.findAll();
    }

    private Coordinate objectFromDto(Coordinate coordinate, CoordinateDto coordinateDto) {

        //Faire les xxx.set(xxx.get());
        return coordinate;
    }
}
