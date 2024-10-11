package fr.humanbooster.vignerontristan.repository;

import fr.humanbooster.vignerontristan.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {

}