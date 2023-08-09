package de.imunixx.backend.repository;

import de.imunixx.api.entity.FixedMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FixedMovementRepository extends JpaRepository<FixedMovement, Long> {

    void deleteFixedMovementById(Long id);

    Optional<FixedMovement> findFixedMovementById(Long id);
    
}
