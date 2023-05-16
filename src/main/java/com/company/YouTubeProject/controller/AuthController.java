package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.AuthDTO;
import com.company.YouTubeProject.dto.AuthResponseDTO;
import com.company.YouTubeProject.dto.RegistrationDTO;
import com.company.YouTubeProject.dto.RegistrationResponseDTO;
import com.company.YouTubeProject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @Autowired
    private AuthService authService;


    @PostMapping("")
    public ResponseEntity<RegistrationResponseDTO> registration(@RequestBody RegistrationDTO dto) {
        return ResponseEntity.ok(authService.registration(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
}
