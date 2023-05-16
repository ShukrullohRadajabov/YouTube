package com.company.YouTubeProject.service;


import com.company.YouTubeProject.dto.AuthDTO;
import com.company.YouTubeProject.dto.AuthResponseDTO;
import com.company.YouTubeProject.dto.RegistrationDTO;
import com.company.YouTubeProject.dto.RegistrationResponseDTO;
import com.company.YouTubeProject.entity.GeneralStatus;
import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.ProfileRole;
import com.company.YouTubeProject.exps.AppBadRequestException;
import com.company.YouTubeProject.exps.ItemNotFoundException;
import com.company.YouTubeProject.repository.ProfileRepository;
import com.company.YouTubeProject.utill.JwtUtil;
import com.company.YouTubeProject.utill.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private MailSenderService mailSenderService;

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
        mailSenderService.sendRegistrationEmail(dto.getEmail());
        profileRepository.save(entity);
        String s = "Verification link was send to email: " + dto.getEmail();
        return new RegistrationResponseDTO(s);
    }


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
        responseDTO.setJwt(JwtUtil.encode(null, entity.getRole()));
        return responseDTO;
    }
}

