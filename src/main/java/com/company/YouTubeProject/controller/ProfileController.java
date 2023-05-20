package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.profile.ProfileAdminCreateDTO;
import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.dto.profile.ProfilePswDTO;
import com.company.YouTubeProject.dto.profile.ProfileUpdateDTO;
import com.company.YouTubeProject.dto.registration.ChangeEmailDTO;
import com.company.YouTubeProject.service.AuthService;
import com.company.YouTubeProject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private AuthService authService;

    @PostMapping({"/private/create/adm", "/private/create/adm/"})
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto) {
//        return ResponseEntity.ok(profileService.create(dto));

        return null;
    }

    @PutMapping("/changePsw")
    public ResponseEntity<?> changePsw (@RequestBody ProfilePswDTO dto) {
//        return ResponseEntity.ok(profileService.changePsw(dto.getPsw()));

        return null;
    }

    @PutMapping("/changeEmail")
    public ResponseEntity<?> changeEmail (@RequestBody ChangeEmailDTO dto) {
        return ResponseEntity.ok(authService.changeEmail(dto));
    }

    @PutMapping("/changeNameSurname")
    public ResponseEntity<?> changeNameSurname (@RequestBody ProfileUpdateDTO dto) {
//        return ResponseEntity.ok(profileService.changeNameSurname(dto.getName(),dto.getSurname()));
        return null;
    }

    @GetMapping(value = "/getProfileDetail")
    public ResponseEntity<ProfileDTO> getProfileDetail() {
        return ResponseEntity.ok(profileService.getProfileDetail());
    }

}
