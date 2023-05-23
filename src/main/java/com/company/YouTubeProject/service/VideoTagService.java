package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.videotag.VideoTagDTO;
import com.company.YouTubeProject.entity.VideoTagEntity;
import com.company.YouTubeProject.repository.VideoTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class VideoTagService {
    @Autowired
    private VideoTagRepository repository;
    public VideoTagDTO add(String videoid,VideoTagDTO dto) {
        VideoTagEntity entity=new VideoTagEntity();
        entity.setTag_ID(dto.getTag_id());
        entity.setId(dto.getId());
        entity.setVideo_ID(dto.getVideo_id());
        entity.setCreated_date(dto.getCreated_date());

        repository.save(entity);
s
        return dto;
    }


    public Boolean delete(String videoid, VideoTagDTO dto) {
        repository.deleteById(videoid);
             return true;
    }
}
