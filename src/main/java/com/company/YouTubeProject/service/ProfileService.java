package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.exeption.MethodNotAllowedExeption;
import com.company.YouTubeProject.repository.ProfileRepository;
import com.company.YouTubeProject.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public ProfileDTO create(ProfileDTO dto) {
        isValidProfile(dto);
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setPassword(MD5Util.getMd5Hash(dto.getPassword()));
        entity.setStatus(GeneralStatus.ACTIVE);
        profileRepository.save(entity); // save profile
        dto.setPassword(null);
        dto.setId(entity.getId());
        return dto;
    }
    public void isValidProfile(ProfileDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (!optional.isEmpty()) {
            throw new MethodNotAllowedExeption("This email or password already use :)");
        }
    }

}
