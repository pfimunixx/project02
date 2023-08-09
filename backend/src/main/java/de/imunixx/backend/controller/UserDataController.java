package de.imunixx.backend.controller;

import de.imunixx.api.controller.UserDataApi;
import de.imunixx.api.model.UserDataDTO;
import de.imunixx.backend.service.UserDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class UserDataController implements UserDataApi {

    @Autowired
    public final UserDataService userDataService;

    @Override
    public ResponseEntity<UserDataDTO> createUserData(UserDataDTO userDataDTO) {
        return ResponseEntity.ok(userDataService.addUserData(userDataDTO));
    }

    @Override
    public ResponseEntity<UserDataDTO> getUserDataById(Long id) {
        return ResponseEntity.ok(userDataService.findUserDataById(id));
    }

    @Override
    public ResponseEntity<UserDataDTO> updateUserDataById(Long id, @RequestBody UserDataDTO userDataDTO) {
        return ResponseEntity.ok(userDataService.updateUserData(userDataDTO));
    }

    @Override
    public ResponseEntity<Void> deleteUserDataById(Long id) {
        userDataService.deleteUserDataById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
