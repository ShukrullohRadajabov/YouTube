package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.VideoLikeDTO;
import com.company.YouTubeProject.entity.VideoLikeEntity;
import org.springframework.stereotype.Service;

@Service
public class VideoLikeService {
    public VideoLikeDTO create(VideoLikeDTO dto) {
        VideoLikeEntity entity=new VideoLikeEntity();

        entity.setId(dto.getId());
        entity.setVideoID(dto.getVideo_id());
        entity.setProfileID(dto.getProfile_id());
        entity.setType(dto.getVideoLike());
        entity.setCreatedDate(dto.getCreated_date());
        return dto;
    }
}
