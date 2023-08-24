package de.imunixx.backend.controller;

import de.imunixx.api.controller.EmailApi;
import de.imunixx.api.model.EmailDTO;
import de.imunixx.backend.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class EmailController implements EmailApi {

    @Autowired
    public final EmailService emailService;

    @Override
    public ResponseEntity<EmailDTO> createEmail(EmailDTO emailDTO) {
        return ResponseEntity.ok(emailService.addEmail(emailDTO));
    }

    @Override
    public ResponseEntity<EmailDTO> getEmailById(Long id) {
        return ResponseEntity.ok(emailService.findEmailById(id));
    }

    @Override
    public ResponseEntity<EmailDTO> updateEmailById(Long id, @RequestBody EmailDTO emailDTO) {
        return ResponseEntity.ok(emailService.updateEmail(emailDTO));
    }

    @Override
    public ResponseEntity<Void> deleteEmailById(Long id) {
        emailService.deleteEmailById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EmailDTO>> getEmailList() {
        return ResponseEntity.ok(emailService.findAllEmails());
    }
}
