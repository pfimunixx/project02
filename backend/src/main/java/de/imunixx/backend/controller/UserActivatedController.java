package de.imunixx.backend.controller;

import de.imunixx.api.controller.UserActivatedApi;
import de.imunixx.api.model.UserActivatedDTO;
import de.imunixx.backend.service.UserActivatedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class UserActivatedController implements UserActivatedApi {

    @Autowired
    public final UserActivatedService userActivatedService;

    @Override
    public ResponseEntity<UserActivatedDTO> getUserActivatedById(Long id) {
        return ResponseEntity.ok(userActivatedService.findUserActivatedById(id));
    }

    @Override
    public ResponseEntity<UserActivatedDTO> updateUserActivatedById(Long id, @RequestBody UserActivatedDTO userActivatedDTO) {
        return ResponseEntity.ok(userActivatedService.updateUserActivated(userActivatedDTO));
    }
}
