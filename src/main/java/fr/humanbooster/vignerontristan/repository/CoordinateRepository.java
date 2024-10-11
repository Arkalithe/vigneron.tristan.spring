package fr.humanbooster.vignerontristan.repository;

import fr.humanbooster.vignerontristan.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

}