package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.auth.AuthDTO;
import com.company.YouTubeProject.dto.auth.AuthResponseDTO;
import com.company.YouTubeProject.dto.jwt.JwtEmailDTO;
import com.company.YouTubeProject.dto.registration.ChangeEmailDTO;
import com.company.YouTubeProject.dto.registration.MailChangeResponseDTO;
import com.company.YouTubeProject.dto.registration.RegistrationDTO;
import com.company.YouTubeProject.dto.registration.RegistrationResponseDTO;
import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.company.YouTubeProject.exeption.AppBadRequestException;
import com.company.YouTubeProject.exeption.ItemNotFoundException;
import com.company.YouTubeProject.repository.ProfileRepository;
import com.company.YouTubeProject.util.JwtUtil;
import com.company.YouTubeProject.util.MD5Util;
import com.company.YouTubeProject.util.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private MailSenderService mailSenderService;

    public AuthResponseDTO login(AuthDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndPassword(
                dto.getEmail(),
                MD5Util.getMd5Hash(dto.getPassword()));
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Email or password incorrect");
        }
        ProfileEntity entity = optional.get();
        if (!entity.getStatus().equals(GeneralStatus.ACTIVE)) {
            throw new AppBadRequestException("Wrong status");
        }
        AuthResponseDTO responseDTO = new AuthResponseDTO();
        responseDTO.setName(entity.getName());
        responseDTO.setSurname(entity.getSurname());
        responseDTO.setRole(entity.getRole());
        responseDTO.setJwt(JwtUtil.encode(entity.getEmail(), entity.getRole()));
        return responseDTO;
    }

    public RegistrationResponseDTO registration(RegistrationDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()) {
            throw new ItemNotFoundException("Email already exists mazgi.");
        }
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setRole(ProfileRole.ROLE_USER);
        entity.setEmail(dto.getEmail());
        entity.setPassword(MD5Util.getMd5Hash(dto.getPassword()));
        entity.setStatus(GeneralStatus.REGISTER);
        mailSenderService.sendRegistrationEmailMime(dto.getEmail());
        profileRepository.save(entity);
        String s = "Verification link was send to email: " + dto.getEmail();
        return new RegistrationResponseDTO(s);
    }
    public MailChangeResponseDTO changeEmail(ChangeEmailDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmail(SpringSecurityUtil.getProfileEmail());
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Email not found mazgi.");
        }
        mailSenderService.sendRegistrationEmailMime1(dto.getNewEmail());
        String s = " link was send to email: " + dto.getNewEmail();
        return new MailChangeResponseDTO(s);
    }

    public RegistrationResponseDTO emailVerification(String jwt) {
        // asjkdhaksdh.daskhdkashkdja
        String email = JwtUtil.decodeEmailVerification(jwt);
        Optional<ProfileEntity> optional = profileRepository.findByEmail(email);
        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Email not found.");
        }
        ProfileEntity entity = optional.get();
        if (!entity.getStatus().equals(GeneralStatus.REGISTER)) {
            throw new AppBadRequestException("Wrong status");
        }
        entity.setStatus(GeneralStatus.ACTIVE);
        profileRepository.save(entity);
        return new RegistrationResponseDTO("Registration Done");
    }
    public MailChangeResponseDTO emailChange(String jwt) {
        JwtEmailDTO dto = JwtUtil.decodeEmailChange(jwt);
        Optional<ProfileEntity> optional = profileRepository.findByEmail(dto.getEmail());
        if (optional.isPresent()) {
            throw new ItemNotFoundException("Yangi kiritmoqchi bulgan emailing borku.");
        }
        profileRepository.changeEmail(dto.getEmail(), dto.getId());
        return new MailChangeResponseDTO("Email Changed!!");
    }
}
