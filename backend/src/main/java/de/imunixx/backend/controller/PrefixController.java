package de.imunixx.backend.controller;

import de.imunixx.api.controller.PrefixApi;
import de.imunixx.api.model.PrefixDTO;
import de.imunixx.backend.service.PrefixService;
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
public class PrefixController implements PrefixApi {

    @Autowired
    public final PrefixService prefixService;

    @Override
    public ResponseEntity<PrefixDTO> createPrefix(PrefixDTO prefixDTO) {
        return ResponseEntity.ok(prefixService.addPrefix(prefixDTO));
    }

    @Override
    public ResponseEntity<PrefixDTO> getPrefixById(Long id) {
        return ResponseEntity.ok(prefixService.findPrefixById(id));
    }

    @Override
    public ResponseEntity<PrefixDTO> updatePrefixById(Long id, @RequestBody PrefixDTO prefixDTO) {
        return ResponseEntity.ok(prefixService.updatePrefix(prefixDTO));
    }

    @Override
    public ResponseEntity<Void> deletePrefixById(Long id) {
        prefixService.deletePrefixById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PrefixDTO>> getPrefixList() {
        return ResponseEntity.ok(prefixService.findAllPrefixes());
    }

    @Override
    public ResponseEntity<List<PrefixDTO>> createPrefixes(List<PrefixDTO> prefixesDTO) {
        return ResponseEntity.ok(prefixService.addPrefixes(prefixesDTO));
    }
}
