package de.imunixx.backend.repository;

import de.imunixx.api.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovementRepository extends JpaRepository<Movement, Long> {

    void deleteMovementById(Long id);

    Optional<Movement> findMovementById(Long id);
}
