package de.imunixx.backend.repository;

import de.imunixx.api.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    void deleteUserDataById(Long id);

    void deleteUserDataByUserId(Long userId);

    Optional<UserData> findUserDataById(Long id);
}
