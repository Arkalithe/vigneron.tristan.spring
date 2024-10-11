package fr.humanbooster.vignerontristan.repository;

import fr.humanbooster.vignerontristan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String username);

    User findByUsername(String name);
}