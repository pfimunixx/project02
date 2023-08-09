package de.imunixx.backend.service;

import de.imunixx.api.entity.FixedMovement;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.FixedMovementDTO;
import de.imunixx.backend.exception.FixedMovementNotFoundException;
import de.imunixx.backend.repository.FixedMovementRepository;
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
public class FixedMovementService {

    private final FixedMovementRepository fixedMovementRepository;
    private final BackEndMapper mapper;

    public FixedMovementDTO addFixedMovement(FixedMovementDTO fixedMovementDTO) {
        FixedMovement entity = mapper.toEntity(fixedMovementDTO);
        return mapper.toDto(fixedMovementRepository.save(entity));
    }

    public FixedMovementDTO findFixedMovementById(Long id) {
        return mapper.toDto(fixedMovementRepository.findFixedMovementById(id)
                .orElseThrow(() -> new FixedMovementNotFoundException("FixedMovement by id" + id + " not found")));
    }

    public FixedMovementDTO updateFixedMovement(FixedMovementDTO fixedMovementDTO) {
        return mapper.toDto(fixedMovementRepository.save(mapper.toEntity(fixedMovementDTO)));
    }

    public void deleteFixedMovementById(Long id) {
        fixedMovementRepository.deleteFixedMovementById(id);
        if(fixedMovementRepository.existsById(id)) {
            throw new FixedMovementNotFoundException("FixedMovement by id" + id + " could not be deleted");
        }
    }

    public List<FixedMovementDTO> findAllFixedMovements() {
        return mapper.toFixedMovementDtoList(fixedMovementRepository.findAll());
    }
}
