package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping({"/private/create/adm", "/private/create/adm/"})
    public ResponseEntity<ProfileDTO> create(@RequestBody ProfileDTO dto) {
        return ResponseEntity.ok(profileService.create(dto));
    }

}
