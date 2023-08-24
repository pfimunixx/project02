package de.imunixx.backend.service;

import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.UserActivatedDTO;
import de.imunixx.backend.exception.UserActivatedNotFoundException;
import de.imunixx.backend.repository.UserActivatedRepository;
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
public class UserActivatedService {

    private final UserActivatedRepository userActivatedRepository;
    private final BackEndMapper mapper;

    public UserActivatedDTO findUserActivatedById(Long id) {
        return mapper.toDto(userActivatedRepository.findUserActivatedById(id)
                .orElseThrow(() -> new UserActivatedNotFoundException("UserActivated by id" + id + " not found")));
    }

    public UserActivatedDTO updateUserActivated(UserActivatedDTO userActivatedDTO) {
        return mapper.toDto(userActivatedRepository.save(mapper.toEntity(userActivatedDTO)));
    }
}
