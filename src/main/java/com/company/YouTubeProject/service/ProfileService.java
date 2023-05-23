package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.profile.ProfileAdminCreateDTO;
import com.company.YouTubeProject.dto.profile.ProfileAttachDTO;
import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.company.YouTubeProject.exeption.MethodNotAllowedExeption;
import com.company.YouTubeProject.repository.ProfileRepository;
import com.company.YouTubeProject.util.MD5Util;
import com.company.YouTubeProject.util.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AttachService attachService;

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

    public Integer changePsw(String psw) {
        return profileRepository.changePsw(MD5Util.getMd5Hash(psw), SpringSecurityUtil.getProfileId());
    }


    public Integer changeNameSurname(String name, String surname) {
        return profileRepository.changeNameSurname(name,surname,SpringSecurityUtil.getProfileId());
    }
    public Integer updatePhoto(ProfileAttachDTO dto) {
        return profileRepository.updatePhoto(dto.getPhotoId(),SpringSecurityUtil.getProfileId());
    }

    public ProfileDTO getProfileDetail() {
        ProfileDTO dto = new ProfileDTO();
        ProfileEntity entity =  profileRepository.getProfileDetail(SpringSecurityUtil.getProfileId());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPhoto(attachService.getAttachLink(entity.getPhotoId()));
        return dto;
    }
}
