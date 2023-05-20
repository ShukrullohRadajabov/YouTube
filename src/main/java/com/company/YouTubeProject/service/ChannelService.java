package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.channel.ChannelCreateDTO;
import com.company.YouTubeProject.dto.channel.ChannelDTO;
import com.company.YouTubeProject.dto.channel.ChannelUpdateDTO;
import com.company.YouTubeProject.dto.channel.UpdateImageDTO;
import com.company.YouTubeProject.entity.ChannelEntity;
import com.company.YouTubeProject.enums.ChannelStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.company.YouTubeProject.exeption.AppBadRequestException;
import com.company.YouTubeProject.repository.ChannelRepository;
import com.company.YouTubeProject.util.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    public String create(ChannelCreateDTO dto) {
        ChannelEntity entity = new ChannelEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImageId(dto.getImageId());
        entity.setBannerId(dto.getBannerId());
        entity.setProfileId(SpringSecurityUtil.getProfileId());
        channelRepository.save(entity);
        return "Channel Created";
    }

    public Integer update(ChannelUpdateDTO dto) {
        return channelRepository.update(dto.getName(), dto.getDescription(), dto.getId());
    }

    public ChannelEntity get(String id) {
        Optional<ChannelEntity> optional = channelRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Channel not found: " + id);
        }
        return optional.get();
    }
    public Integer updatePhoto(UpdateImageDTO dto) {
        return channelRepository.updateImage(dto.getImageId(),dto.getId());
    }
    public Integer updateBanner(UpdateImageDTO dto) {
        return channelRepository.updateBanner(dto.getImageId(),dto.getId());
    }

    public Page<ChannelDTO> pagingtion(int page, int size) {
        //Sort sort = Sort.by(Sort.Direction.DESC, "created_date");
        Pageable pageable = PageRequest.of(page - 1, size);//, sort
        Page<ChannelEntity> pageObj = channelRepository.findAll(pageable);
        long totalCount = pageObj.getTotalElements();
        List<ChannelEntity> entityList = pageObj.getContent();
        List<ChannelDTO> dtoList = convertToDTO(entityList);
        Page<ChannelDTO> response = new PageImpl<ChannelDTO>(dtoList, pageable, totalCount);
        return response;
    }

    public ChannelDTO getChannelDetail(String channelId) {
        return convertToDTO(channelRepository.getChannelDetail(channelId));
    }

    public String updateStatus(String channelId) {
        ProfileRole role = SpringSecurityUtil.getProfileRole();
        ChannelEntity entity = get(channelId);
        if (role.equals(ProfileRole.ROLE_USER) && entity.getStatus().equals(ChannelStatus.ACTIVE)) {
            channelRepository.updateStatus(ChannelStatus.NONE, channelId);
            return "Changed TO NONE";
        }
        if ((role.equals(ProfileRole.ROLE_USER) && entity.getStatus().equals(ChannelStatus.NONE) ||
                (role.equals(ProfileRole.ROLE_ADMIN) && entity.getStatus().equals(ChannelStatus.BLOCK)))) {
            channelRepository.updateStatus(ChannelStatus.ACTIVE, channelId);
            return "Changed TO ACTIVE";
        }
        if (role.equals(ProfileRole.ROLE_ADMIN) && entity.getStatus().equals(ChannelStatus.ACTIVE)) {
            channelRepository.updateStatus(ChannelStatus.BLOCK, channelId);
            return "Changed TO BLOCK";
        }
        return "Error";
    }
    public List<ChannelDTO> userChannelList() {
        return convertToDTO(channelRepository.userChannelList(SpringSecurityUtil.getProfileId()));
    }

    public List<ChannelDTO> convertToDTO(List<ChannelEntity> entityList) {
        List<ChannelDTO> dtoList = new LinkedList<>();
        entityList.forEach(entity -> {
            ChannelDTO dto = new ChannelDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setStatus(entity.getStatus());
            dto.setImageId(entity.getImageId());
            dto.setBannerId(entity.getBannerId());
            dto.setProfileId(entity.getProfileId());
            dtoList.add(dto);
        });
        return dtoList;
    }

    public ChannelDTO convertToDTO(ChannelEntity entity) {
        ChannelDTO dto = new ChannelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setImageId(entity.getImageId());
        dto.setBannerId(entity.getBannerId());
        dto.setProfileId(entity.getProfileId());
        return dto;
    }



}
