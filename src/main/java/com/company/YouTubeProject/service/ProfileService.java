package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.exeption.AppBadRequestException;
import com.company.YouTubeProject.exeption.MethodNotAllowedExeption;
import com.company.YouTubeProject.repository.ProfileRepository;
import com.company.YouTubeProject.util.MD5Util;
import com.company.YouTubeProject.util.SpringSecurityUtil;
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
        profileRepository.save(entity);
        profileRepository.save(entity); // save profile
        dto.setPassword(null);
        dto.setId(entity.getId());
        return dto;
    }

    public Boolean update(String password) {
        Integer profileId = get(SpringSecurityUtil.getProfileId()).getId();
        return profileRepository.changePassword(password,profileId);
    }

    public void isValidProfile(ProfileDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (!optional.isEmpty()) {
            throw new MethodNotAllowedExeption("This email or password already use :)");
        }
    }

    public ProfileEntity get(Integer profileId) {
        Optional<ProfileEntity> optional = profileRepository.findById(profileId);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Profile not found: " + profileId);
        }
        return optional.get();
    }
    public ProfileDTO findAll() {
        Integer profileId = get(SpringSecurityUtil.getProfileId()).getId();
        ProfileDTO dto = converToDTO(profileRepository.getAllId(profileId));
        return dto;
    }
    public ProfileDTO converToDTO(ProfileEntity entity) {
        ProfileDTO dto = new ProfileDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
      //dto.setPhoto(entity.getPhoto);
        return dto;
    }
}
