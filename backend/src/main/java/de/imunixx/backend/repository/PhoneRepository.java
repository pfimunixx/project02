package de.imunixx.backend.repository;

import de.imunixx.api.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneRepository  extends JpaRepository<Phone, Long> {

    void deletePhoneById(Long id);

    Optional<Phone> findPhoneById(Long id);
}
