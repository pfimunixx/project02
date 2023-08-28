package de.imunixx.backend.service;

import de.imunixx.api.entity.Prefix;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.PrefixDTO;
import de.imunixx.backend.exception.PrefixNotFoundException;
import de.imunixx.backend.repository.PrefixRepository;
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
public class PrefixService {

    private final PrefixRepository prefixRepository;
    private final BackEndMapper mapper;

    public PrefixDTO addPrefix(PrefixDTO prefixDTO) {
        Prefix entity = mapper.toEntity(prefixDTO);
        return mapper.toDto(prefixRepository.save(entity));
    }

    public PrefixDTO findPrefixById(Long id) {
        return mapper.toDto(prefixRepository.findPrefixById(id)
                .orElseThrow(() -> new PrefixNotFoundException("Prefix by id" + id + " not found")));
    }

    public PrefixDTO updatePrefix(PrefixDTO prefixDTO) {
        return mapper.toDto(prefixRepository.save(mapper.toEntity(prefixDTO)));
    }

    public void deletePrefixById(Long id) {
        prefixRepository.deletePrefixById(id);
        if(prefixRepository.existsById(id)) {
            throw new PrefixNotFoundException("Prefix by id" + id + " could not be deleted");
        }
    }

    public List<PrefixDTO> findAllPrefixes() {
        return mapper.toPrefixDtoList(prefixRepository.findAll());
    }

    public List<PrefixDTO> addPrefixes(List<PrefixDTO> prefixesDTO) {
        List<Prefix> entityList = mapper.toPrefixList(prefixesDTO);
        return mapper.toPrefixDtoList(prefixRepository.saveAll(entityList));
    }
}
