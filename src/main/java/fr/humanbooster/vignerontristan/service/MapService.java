package fr.humanbooster.vignerontristan.service;

import fr.humanbooster.vignerontristan.dto.RoundDto;
import fr.humanbooster.vignerontristan.entity.Round;
import fr.humanbooster.vignerontristan.repository.MapRepository;
import fr.humanbooster.vignerontristan.entity.Map;
import fr.humanbooster.vignerontristan.dto.MapDto;

import fr.humanbooster.vignerontristan.service.interfaces.ServiceIdInterface;
import fr.humanbooster.vignerontristan.service.interfaces.ServiceInterfaceBase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class MapService implements ServiceInterfaceBase<Map, MapDto>, ServiceIdInterface<Map, Long> {

    private final MapRepository mapRepository;

    @Override
    public Map create(MapDto mapDto) {
        return mapRepository.saveAndFlush(objectFromDto(new Map(), mapDto));
    }
    @Override
    public Map findById(Long id) {
        return mapRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Override
    public List<Map> list() {
        return mapRepository.findAll();
    }

    private Map objectFromDto(Map map, MapDto mapDto) {
        map.setName(mapDto.getName());
        map.setCreatedAt(LocalDateTime.now());
        return map;
    }
}
