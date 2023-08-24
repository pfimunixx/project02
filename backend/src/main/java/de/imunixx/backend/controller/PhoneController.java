package de.imunixx.backend.controller;

import de.imunixx.api.controller.PhoneApi;
import de.imunixx.api.model.PhoneDTO;
import de.imunixx.backend.service.PhoneService;
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
public class PhoneController implements PhoneApi {

    @Autowired
    public final PhoneService phoneService;

    @Override
    public ResponseEntity<PhoneDTO> createPhone(PhoneDTO phoneDTO) {
        return ResponseEntity.ok(phoneService.addPhone(phoneDTO));
    }

    @Override
    public ResponseEntity<PhoneDTO> getPhoneById(Long id) {
        return ResponseEntity.ok(phoneService.findPhoneById(id));
    }

    @Override
    public ResponseEntity<PhoneDTO> updatePhoneById(Long id, @RequestBody PhoneDTO phoneDTO) {
        return ResponseEntity.ok(phoneService.updatePhone(phoneDTO));
    }

    @Override
    public ResponseEntity<Void> deletePhoneById(Long id) {
        phoneService.deletePhoneById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PhoneDTO>> getPhoneList() {
        return ResponseEntity.ok(phoneService.findAllPhones());
    }
}
