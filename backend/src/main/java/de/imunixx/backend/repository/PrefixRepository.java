package de.imunixx.backend.repository;

import de.imunixx.api.entity.Phone;
import de.imunixx.api.entity.Prefix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrefixRepository extends JpaRepository<Prefix, Long> {

    void deletePrefixById(Long id);

    Optional<Prefix> findPrefixById(Long id);

}
