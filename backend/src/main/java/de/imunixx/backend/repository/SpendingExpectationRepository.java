package de.imunixx.backend.repository;

import de.imunixx.api.entity.SpendingExpectation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpendingExpectationRepository extends JpaRepository<SpendingExpectation, Long> {

    void deleteSpendingExpectationById(Long id);

    Optional<SpendingExpectation> findSpendingExpectationById(Long id);
}
