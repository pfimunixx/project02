package de.imunixx.backend.service;

import de.imunixx.api.entity.Phone;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.PhoneDTO;
import de.imunixx.backend.exception.PhoneNotFoundException;
import de.imunixx.backend.repository.PhoneRepository;
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
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final BackEndMapper mapper;

    public PhoneDTO addPhone(PhoneDTO phoneDTO) {
        Phone entity = mapper.toEntity(phoneDTO);
        return mapper.toDto(phoneRepository.save(entity));
    }

    public PhoneDTO findPhoneById(Long id) {
        return mapper.toDto(phoneRepository.findPhoneById(id)
                .orElseThrow(() -> new PhoneNotFoundException("Phone by id" + id + " not found")));
    }

    public PhoneDTO updatePhone(PhoneDTO phoneDTO) {
        return mapper.toDto(phoneRepository.save(mapper.toEntity(phoneDTO)));
    }

    public void deletePhoneById(Long id) {
        phoneRepository.deletePhoneById(id);
        if(phoneRepository.existsById(id)) {
            throw new PhoneNotFoundException("Phone by id" + id + " could not be deleted");
        }
    }

    public List<PhoneDTO> findAllPhones() {
        return mapper.toPhoneDtoList(phoneRepository.findAll());
    }

    
}
