package de.imunixx.backend.repository;

import java.util.List;
import java.util.Optional;

import de.imunixx.api.entity.Profile;
import de.imunixx.api.entity.User;
import de.imunixx.api.model.ProfileDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);

    @Query("SELECT u.profilesList FROM User u WHERE u.id = :userId")
    List<Profile> findProfilesListById(@Param("userId") Long userId);
}
