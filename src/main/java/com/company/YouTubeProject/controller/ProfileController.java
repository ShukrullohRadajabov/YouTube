package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.profile.*;
import com.company.YouTubeProject.dto.registration.ChangeEmailDTO;
import com.company.YouTubeProject.service.AuthService;
import com.company.YouTubeProject.service.ProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private AuthService authService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    @PostMapping({"/private/create/adm", "/private/create/adm/"})
    public ResponseEntity<?> create(@RequestBody ProfileAdminCreateDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

    @PutMapping("/changePsw")
    public ResponseEntity<?> changePsw (@RequestBody ProfilePswDTO dto) {
        return ResponseEntity.ok(profileService.changePsw(dto.getPsw()));
    }

    @PutMapping("/changeEmail")
    public ResponseEntity<?> changeEmail (@RequestBody ChangeEmailDTO dto) {
        return ResponseEntity.ok(authService.changeEmail(dto));
    }

    @PutMapping("/changeNameSurname")
    public ResponseEntity<?> changeNameSurname (@RequestBody ProfileUpdateDTO dto) {
        return ResponseEntity.ok(profileService.changeNameSurname(dto.getName(),dto.getSurname()));
    }
    @PutMapping("/updatePhoto")
    public ResponseEntity<?> updatePhoto(@RequestBody ProfileAttachDTO dto) {
        return ResponseEntity.ok(profileService.updatePhoto(dto));
    }

    @GetMapping(value = "/getProfileDetail")
    public ResponseEntity<ProfileDTO> getProfileDetail() {
        return ResponseEntity.ok(profileService.getProfileDetail());
    }

}
