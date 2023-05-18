package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.playlist.PlaylistDTO;
import com.company.YouTubeProject.entity.PlaylistEntity;
import com.company.YouTubeProject.enums.PlaylistStatus;
import com.company.YouTubeProject.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    public PlaylistDTO create(PlaylistDTO dto) {
        PlaylistEntity playlistEntity=new PlaylistEntity();
        playlistEntity.setChannelId(dto.getChannelId());
        playlistEntity.setDescription(dto.getDescription());
        playlistEntity.setStatus(dto.getStatus());
        playlistEntity.setOrderNumber(dto.getOrderNumber());
        playlistRepository.save(playlistEntity);
        return dto;
    }

    public PlaylistDTO update(PlaylistDTO dto) {
        PlaylistEntity playlistEntity=new PlaylistEntity();
        playlistEntity.setId(dto.getId());
        playlistEntity.setChannelId(dto.getChannelId());
        playlistEntity.setDescription(dto.getDescription());
        playlistEntity.setStatus(dto.getStatus());
        playlistEntity.setOrderNumber(dto.getOrderNumber());
        playlistRepository.save(playlistEntity);
        return dto;
    }

    public PlaylistEntity delete(String id) {
        PlaylistEntity playlistEntity=getPlaylist(id);
        if (playlistEntity.getVisible()==true){
            playlistEntity.setVisible(false);
        }else playlistEntity.setVisible(true);
        playlistRepository.save(playlistEntity);
        return playlistEntity;
    }
    public PlaylistEntity getPlaylist(String id){
        Optional<PlaylistEntity> optional = playlistRepository.findById(id);
        return optional.get();
    }

    public String updateStatus(String id) {
        PlaylistEntity playlistEntity=getPlaylist(id);
        if (playlistEntity.getStatus().toString().equals("PUBLIC")){
            playlistEntity.setStatus(PlaylistStatus.PRIVATE);
        }else playlistEntity.setStatus(PlaylistStatus.PUBLIC);;
        playlistRepository.save(playlistEntity);
        return "playlist status change to " + playlistEntity.getStatus().toString();
    }
    public Page<PlaylistDTO> getPlaylistPaging(int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        Page<PlaylistEntity> pageObj = playlistRepository.findAll(paging);

        Long totalCount = pageObj.getTotalElements();

        List<PlaylistEntity> entityList = pageObj.getContent();
        List<PlaylistDTO> list = new LinkedList<>();
        entityList.forEach(entity -> {
            list.add(entityToDto(entity));
        });
        Page<PlaylistDTO> response = new PageImpl<PlaylistDTO>(list, paging, totalCount);
        return response;
    }
    public PlaylistDTO entityToDto(PlaylistEntity playlistEntity){
        PlaylistDTO playlistDTO=new PlaylistDTO();
        playlistDTO.setId(playlistDTO.getId());
        playlistDTO.setChannelId(playlistEntity.getChannelId());
        playlistDTO.setDescription(playlistEntity.getDescription());
        playlistDTO.setOrderNumber(playlistEntity.getOrderNumber());
        playlistDTO.setStatus(playlistEntity.getStatus());
        return playlistDTO;
    }
}
