package de.imunixx.backend.service;

import de.imunixx.api.entity.Profile;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.ProfileDTO;
import de.imunixx.backend.exception.ProfileNotFoundException;
import de.imunixx.backend.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@Slf4j
@AllArgsConstructor
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final BackEndMapper mapper;

    public ProfileDTO addProfile(ProfileDTO profileDTO) {
        Profile entity = mapper.toEntity(profileDTO);
        return mapper.toDto(profileRepository.save(entity));
    }

    public ProfileDTO findProfileById(Long id) {
        return mapper.toDto(profileRepository.findProfileById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile by id" + id + " not found")));
    }

    public ProfileDTO updateProfile(ProfileDTO profileDTO) {
        return mapper.toDto(profileRepository.save(mapper.toEntity(profileDTO)));
    }

    public void deleteProfileById(Long id) {
        profileRepository.deleteProfileById(id);
        if(profileRepository.existsById(id)) {
            throw new ProfileNotFoundException("Profile by id" + id + " could not be deleted");
        }
    }

    public List<ProfileDTO> findAllProfiles() {
        return mapper.toProfileDtoList(profileRepository.findAll());
    }
}
