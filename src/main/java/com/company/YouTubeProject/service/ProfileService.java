package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.profile.ProfileAdminCreateDTO;

import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.company.YouTubeProject.exeption.MethodNotAllowedExeption;
import com.company.YouTubeProject.exps.AppBadRequestException;
import com.company.YouTubeProject.repository.ProfileRepository;

import com.company.YouTubeProject.utill.MD5Util;
import com.company.YouTubeProject.utill.SpringSecurityUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;


    public Boolean update(String password) {
//        Integer profileId = get(SpringSecurityUtill.getProfileId()).getId();
//        return profileRepository.changePassword(password,profileId);
        return null;

    }

    public String create(ProfileAdminCreateDTO dto) {
        ProfileEntity entity = new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setStatus(GeneralStatus.BLOCK);
        if (dto.getRole().equals(ProfileRole.ROLE_USER)){
            return "You can't Create User";
        }
        entity.setRole(dto.getRole());
        profileRepository.save(entity);
        return "Created";
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
        Integer profileId = get(SpringSecurityUtill.getProfileId()).getId();
        ProfileDTO dto = converToDTO(profileRepository.getAllId(profileId));
        return dto;
    }

    public ProfileDTO getProfileDetail() {
        ProfileDTO dto = new ProfileDTO();
        ProfileEntity entity =  profileRepository.getProfileDetail(SpringSecurityUtill.getProfileId());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
      //dto.setPhoto(entity.getPhoto);
        return dto;
    }
}
