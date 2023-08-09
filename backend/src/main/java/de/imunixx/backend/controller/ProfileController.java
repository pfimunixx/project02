package de.imunixx.backend.controller;


import de.imunixx.api.controller.ProfileApi;
import de.imunixx.api.model.ProfileDTO;
import de.imunixx.backend.service.ProfileService;
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
public class ProfileController implements ProfileApi {

    @Autowired
    public final ProfileService profileService;

    @Override
    public ResponseEntity<ProfileDTO> createProfile(ProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.addProfile(profileDTO));
    }

    @Override
    public ResponseEntity<ProfileDTO> getProfileById(Long id) {
        return ResponseEntity.ok(profileService.findProfileById(id));
    }

    @Override
    public ResponseEntity<ProfileDTO> updateProfileById(Long id, @RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.updateProfile(profileDTO));
    }

    @Override
    public ResponseEntity<Void> deleteProfileById(Long id) {
        profileService.deleteProfileById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProfileDTO>> getProfileList() {
        return ResponseEntity.ok(profileService.findAllProfiles());
    }
}
