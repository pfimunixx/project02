package de.imunixx.backend.service;

import de.imunixx.api.entity.Email;
import de.imunixx.api.mapper.BackEndMapper;
import de.imunixx.api.model.EmailDTO;
import de.imunixx.backend.exception.EmailNotFoundException;
import de.imunixx.backend.repository.EmailRepository;
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
public class EmailService {

    private final EmailRepository emailRepository;
    private final BackEndMapper mapper;

    public EmailDTO addEmail(EmailDTO emailDTO) {
        Email entity = mapper.toEntity(emailDTO);
        return mapper.toDto(emailRepository.save(entity));
    }

    public EmailDTO findEmailById(Long id) {
        return mapper.toDto(emailRepository.findEmailById(id)
                .orElseThrow(() -> new EmailNotFoundException("Email by id" + id + " not found")));
    }

    public EmailDTO updateEmail(EmailDTO emailDTO) {
        return mapper.toDto(emailRepository.save(mapper.toEntity(emailDTO)));
    }

    public void deleteEmailById(Long id) {
        emailRepository.deleteEmailById(id);
        if(emailRepository.existsById(id)) {
            throw new EmailNotFoundException("Email by id" + id + " could not be deleted");
        }
    }

    public List<EmailDTO> findAllEmails() {
        return mapper.toEmailDtoList(emailRepository.findAll());
    }
}
