package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.auth.AuthDTO;
import com.company.YouTubeProject.dto.auth.AuthResponseDTO;
import com.company.YouTubeProject.dto.registration.MailChangeResponseDTO;
import com.company.YouTubeProject.dto.registration.RegistrationDTO;
import com.company.YouTubeProject.dto.registration.RegistrationResponseDTO;
import com.company.YouTubeProject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }
    @PostMapping("/register")
    public ResponseEntity<RegistrationResponseDTO> registration(@RequestBody RegistrationDTO dto) {
        return ResponseEntity.ok(authService.registration(dto));
    }

    @GetMapping("/email/verification/{email}")
    public ResponseEntity<RegistrationResponseDTO> verification(@PathVariable("email") String text) {
        return ResponseEntity.ok(authService.emailVerification(text));
    }
    @GetMapping("/email/changeEmail/{email}")
    public ResponseEntity<MailChangeResponseDTO> emailChange(@PathVariable("email") String text) {
        return ResponseEntity.ok(authService.emailChange(text));
    }
}
