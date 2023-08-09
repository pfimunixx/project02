package de.imunixx.backend.controller;

import de.imunixx.api.controller.FixedMovementApi;
import de.imunixx.api.model.FixedMovementDTO;
import de.imunixx.backend.service.FixedMovementService;
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
public class FixedMovementController implements FixedMovementApi {

    @Autowired
    public final FixedMovementService fixedMovementService;

    @Override
    public ResponseEntity<FixedMovementDTO> createFixedMovement(FixedMovementDTO fixedMovementDTO) {
        return ResponseEntity.ok(fixedMovementService.addFixedMovement(fixedMovementDTO));
    }

    @Override
    public ResponseEntity<FixedMovementDTO> getFixedMovementById(Long id) {
        return ResponseEntity.ok(fixedMovementService.findFixedMovementById(id));
    }

    @Override
    public ResponseEntity<FixedMovementDTO> updateFixedMovementById(Long id, @RequestBody FixedMovementDTO fixedMovementDTO) {
        return ResponseEntity.ok(fixedMovementService.updateFixedMovement(fixedMovementDTO));
    }

    @Override
    public ResponseEntity<Void> deleteFixedMovementById(Long id) {
        fixedMovementService.deleteFixedMovementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FixedMovementDTO>> getFixedMovementList() {
        return ResponseEntity.ok(fixedMovementService.findAllFixedMovements());
    }
}
