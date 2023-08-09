package de.imunixx.backend.controller;

import de.imunixx.api.controller.MovementApi;
import de.imunixx.api.model.MovementDTO;
import de.imunixx.backend.service.MovementService;
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
public class MovementController implements MovementApi {

    @Autowired
    public final MovementService movementService;

    @Override
    public ResponseEntity<MovementDTO> createMovement(MovementDTO movementDTO) {
        return ResponseEntity.ok(movementService.addMovement(movementDTO));
    }

    @Override
    public ResponseEntity<MovementDTO> getMovementById(Long id) {
        return ResponseEntity.ok(movementService.findMovementById(id));
    }

    @Override
    public ResponseEntity<MovementDTO> updateMovementById(Long id, @RequestBody MovementDTO movementDTO) {
        return ResponseEntity.ok(movementService.updateMovement(movementDTO));
    }

    @Override
    public ResponseEntity<Void> deleteMovementById(Long id) {
        movementService.deleteMovementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MovementDTO>> getMovementList() {
        return ResponseEntity.ok(movementService.findAllMovements());
    }
}
