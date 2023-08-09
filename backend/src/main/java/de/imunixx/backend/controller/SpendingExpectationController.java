package de.imunixx.backend.controller;

import de.imunixx.api.controller.SpendingExpectationApi;
import de.imunixx.api.model.SpendingExpectationDTO;
import de.imunixx.backend.service.SpendingExpectationService;
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
public class SpendingExpectationController implements SpendingExpectationApi {

    @Autowired
    public final SpendingExpectationService spendingExpectationService;

    @Override
    public ResponseEntity<SpendingExpectationDTO> createSpendingExpectation(SpendingExpectationDTO spendingExpectationDTO) {
        return ResponseEntity.ok(spendingExpectationService.addSpendingExpectation(spendingExpectationDTO));
    }

    @Override
    public ResponseEntity<SpendingExpectationDTO> getSpendingExpectationById(Long id) {
        return ResponseEntity.ok(spendingExpectationService.findSpendingExpectationById(id));
    }

    @Override
    public ResponseEntity<SpendingExpectationDTO> updateSpendingExpectationById(Long id, @RequestBody SpendingExpectationDTO spendingExpectationDTO) {
        return ResponseEntity.ok(spendingExpectationService.updateSpendingExpectation(spendingExpectationDTO));
    }

    @Override
    public ResponseEntity<Void> deleteSpendingExpectationById(Long id) {
        spendingExpectationService.deleteSpendingExpectationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SpendingExpectationDTO>> getSpendingExpectationList() {
        return ResponseEntity.ok(spendingExpectationService.findAllSpendingExpectations());
    }
}
