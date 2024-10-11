package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.repository.MapRepository;
import fr.humanbooster.vignerontristan.entity.Map;
import fr.humanbooster.vignerontristan.dto.MapDto;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class MapService {

    private final MapRepository mapRepository;


    public Map create(MapDto mapDto) {
        return mapRepository.saveAndFlush(objectFromDto(new Map(), mapDto));
    }




    public Map findById(Long id) {
        return mapRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    public List<Map> list() {
        return mapRepository.findAll();
    }

    private Map objectFromDto(Map map, MapDto mapDto) {
        map.setName(mapDto.getName());
        map.setCreatedAt(LocalDateTime.now());
        return map;
    }
}
