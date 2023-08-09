package de.imunixx.backend.service;

import de.imunixx.api.entity.SpendingExpectation;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.SpendingExpectationDTO;
import de.imunixx.backend.exception.SpendingExpectationNotFoundException;
import de.imunixx.backend.repository.SpendingExpectationRepository;
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
public class SpendingExpectationService {

    private final SpendingExpectationRepository spendingExpectationRepository;
    private final BackEndMapper mapper;

    public SpendingExpectationDTO addSpendingExpectation(SpendingExpectationDTO spendingExpectationDTO) {
        SpendingExpectation entity = mapper.toEntity(spendingExpectationDTO);
        return mapper.toDto(spendingExpectationRepository.save(entity));
    }

    public SpendingExpectationDTO findSpendingExpectationById(Long id) {
        return mapper.toDto(spendingExpectationRepository.findSpendingExpectationById(id)
                .orElseThrow(() -> new SpendingExpectationNotFoundException("SpendingExpectation by id" + id + " not found")));
    }

    public SpendingExpectationDTO updateSpendingExpectation(SpendingExpectationDTO spendingExpectationDTO) {
        return mapper.toDto(spendingExpectationRepository.save(mapper.toEntity(spendingExpectationDTO)));
    }

    public void deleteSpendingExpectationById(Long id) {
        spendingExpectationRepository.deleteSpendingExpectationById(id);
        if(spendingExpectationRepository.existsById(id)) {
            throw new SpendingExpectationNotFoundException("SpendingExpectation by id" + id + " could not be deleted");
        }
    }

    public List<SpendingExpectationDTO> findAllSpendingExpectations() {
        return mapper.toSpendingExpectationDtoList(spendingExpectationRepository.findAll());
    }
}
