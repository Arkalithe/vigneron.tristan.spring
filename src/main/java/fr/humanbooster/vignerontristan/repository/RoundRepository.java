package fr.humanbooster.vignerontristan.repository;

import fr.humanbooster.vignerontristan.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

}