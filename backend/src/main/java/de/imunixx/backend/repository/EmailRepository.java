package de.imunixx.backend.repository;

import de.imunixx.api.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {

    void deleteEmailById(Long id);

    Optional<Email> findEmailById(Long id);
}
