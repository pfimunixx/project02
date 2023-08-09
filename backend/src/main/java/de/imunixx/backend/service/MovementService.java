package de.imunixx.backend.service;

import de.imunixx.api.entity.Movement;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.MovementDTO;
import de.imunixx.backend.exception.MovementNotFoundException;
import de.imunixx.backend.repository.MovementRepository;
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
public class MovementService {

    private final MovementRepository movementRepository;
    private final BackEndMapper mapper;

    public MovementDTO addMovement(MovementDTO movementDTO) {
        Movement entity = mapper.toEntity(movementDTO);
        return mapper.toDto(movementRepository.save(entity));
    }

    public MovementDTO findMovementById(Long id) {
        return mapper.toDto(movementRepository.findMovementById(id)
                .orElseThrow(() -> new MovementNotFoundException("Movement by id" + id + " not found")));
    }

    public MovementDTO updateMovement(MovementDTO movementDTO) {
        return mapper.toDto(movementRepository.save(mapper.toEntity(movementDTO)));
    }

    public void deleteMovementById(Long id) {
        movementRepository.deleteMovementById(id);
        if(movementRepository.existsById(id)) {
            throw new MovementNotFoundException("Movement by id" + id + " could not be deleted");
        }
    }

    public List<MovementDTO> findAllMovements() {
        return mapper.toMovementDtoList(movementRepository.findAll());
    }
}
