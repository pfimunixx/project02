package de.imunixx.backend.service;

import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.UserDataDTO;
import de.imunixx.backend.exception.UserDataNotFoundException;
import de.imunixx.backend.repository.UserDataRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Slf4j
@AllArgsConstructor
@Transactional
public class UserDataService {

    private final UserDataRepository userDataRepository;
    private final BackEndMapper mapper;

    public UserDataDTO findUserDataById(Long id) {
        return mapper.toDto(userDataRepository.findUserDataById(id)
                .orElseThrow(() -> new UserDataNotFoundException("UserData by id" + id + " not found")));
    }

    public UserDataDTO updateUserData(UserDataDTO userDataDTO) {
        return mapper.toDto(userDataRepository.save(mapper.toEntity(userDataDTO)));
    }
}
