package de.imunixx.backend.repository;

import de.imunixx.api.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    void deleteProfileById(Long id);

    Optional<Profile> findProfileById(Long id);
}
