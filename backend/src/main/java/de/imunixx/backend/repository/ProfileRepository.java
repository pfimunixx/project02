package de.imunixx.backend.repository;

import de.imunixx.api.entity.FixedMovement;
import de.imunixx.api.entity.Movement;
import de.imunixx.api.entity.Profile;
import de.imunixx.api.entity.SpendingExpectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    void deleteProfileById(Long id);

    Optional<Profile> findProfileById(Long id);

    @Query("SELECT p.movementsList FROM Profile p WHERE p.id = :profileId")
    List<Movement> findMovementsListById(@Param("profileId") Long profileId);

    @Query("SELECT p.fixedMovementsList FROM Profile p WHERE p.id = :profileId")
    List<FixedMovement> findFixedMovementsListById(@Param("profileId") Long profileId);

    @Query("SELECT p.spendingExpectationsList FROM Profile p WHERE p.id = :profileId")
    List<SpendingExpectation> findSpendingExpectationsListById(@Param("profileId") Long profileId);
}
