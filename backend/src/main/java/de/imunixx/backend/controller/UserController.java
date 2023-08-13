package de.imunixx.backend.controller;

import de.imunixx.api.controller.UserApi;
import de.imunixx.api.model.*;
import de.imunixx.backend.exception.UserNotFoundException;
import de.imunixx.backend.service.UserDataService;
import de.imunixx.backend.service.UserService;
import de.imunixx.backend.service.UserActivatedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class UserController implements UserApi {

    @Autowired
    public final UserService userService;

    @Override
    public ResponseEntity<UserDTO> createUser(UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userService.addUser(userCreateDTO));
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @Override
    public ResponseEntity<UserDTO> updateUserById(Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUserList() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @Override
    public ResponseEntity<List<ProfileDTO>> getProfilesListById(Long id) {
        return ResponseEntity.ok(userService.findProfilesListById(id));
    }

    @Override
    public ResponseEntity<UserDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            return ResponseEntity.ok().body(userService.login(userLoginDTO));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
