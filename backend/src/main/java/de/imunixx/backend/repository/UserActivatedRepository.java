package de.imunixx.backend.repository;

import de.imunixx.api.entity.UserActivated;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserActivatedRepository extends JpaRepository<UserActivated, Long> {

    void deleteUserActivatedById(Long id);

    void deleteUserActivatedByUserId(Long userId);

    Optional<UserActivated> findUserActivatedById(Long id);
}
