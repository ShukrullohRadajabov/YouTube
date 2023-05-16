package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.profile.ProfileDTO;
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

    @PostMapping({"/private/create/adm", "/private/create/adm/"})
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }
    @PutMapping(value = "/public/updatePsw")
    public ResponseEntity<?> update(@RequestBody String password) {
        return ResponseEntity.ok(profileService.update(password));
    }
    @GetMapping("/public/getAll")
    public ResponseEntity<ProfileDTO> getAll() {
        return ResponseEntity.ok(profileService.findAll());
    }


}
