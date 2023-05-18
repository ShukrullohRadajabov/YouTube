package com.company.YouTubeProject.service;


import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.company.YouTubeProject.exeption.MethodNotAllowedExeption;
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
    @Qualifier("getDataSource")
    @Autowired
    private DataSource get;


    public Boolean update(String password) {
//        Integer profileId = get(SpringSecurityUtill.getProfileId()).getId();
//        return profileRepository.changePassword(password,profileId);
        return null;
    }

    public void isValidProfile(ProfileDTO dto) {
        Optional<ProfileEntity> optional = profileRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (!optional.isEmpty()) {
            throw new MethodNotAllowedExeption("This email or password already use :)");
        }
    }

    public Integer changePsw(String psw) {
//        return profileRepository.changePsw(MD5Util.getMd5Hash(psw), SpringSecurityUtill.getProfileId());
        return null;
    }
    public ProfileDTO findAll() {
//        Integer profileId = get(SpringSecurityUtill.getProfileId()).getId();
//        ProfileDTO dto = converToDTO(profileRepository.getAllId(profileId));
        return null;
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
