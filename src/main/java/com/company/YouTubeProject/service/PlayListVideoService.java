package com.company.YouTubeProject.service;
import com.company.YouTubeProject.dto.playlistvideo.PlayListVideoDTO;
import com.company.YouTubeProject.entity.PlayListVideoEntity;;
import com.company.YouTubeProject.repository.PlaylistVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PlayListVideoService {
    @Autowired
    private PlaylistVideoRepository playlistVideoRepository;


    public PlayListVideoDTO create(PlayListVideoDTO dto) {
        PlayListVideoEntity entity = new PlayListVideoEntity();
        entity.setId(dto.getId());
        entity.setPlaylistId(dto.getPlayListId());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setVideo_id(dto.getVideoId());
        entity.setOrderNum(dto.getOrderNum());
        entity.setPlaylistId(dto.getPlayListId());
        playlistVideoRepository.save(entity);
        return dto;
    }
}
