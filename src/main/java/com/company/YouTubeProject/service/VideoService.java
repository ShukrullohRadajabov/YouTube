package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.video.VideoCreateDTO;
import com.company.YouTubeProject.dto.video.VideoShortInfoDTO;
import com.company.YouTubeProject.entity.VideoEntity;
import com.company.YouTubeProject.enums.VideoLike;
import com.company.YouTubeProject.enums.VideoStatus;
import com.company.YouTubeProject.exeption.AppBadRequestException;
import com.company.YouTubeProject.mapper.VideoShortInfoMapper;
import com.company.YouTubeProject.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private AttachService attachService;
    public String create(VideoCreateDTO dto) {
        VideoEntity entity = new VideoEntity();
        Optional<VideoEntity> optional = videoRepository.findByTitle(dto.getTitle());
        if (optional.isPresent()){
            return "This title is already used!!";
        }
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setCategoryId(dto.getCategoryId());
        entity.setPreviewId(dto.getPreviewId());
        entity.setVideoId(dto.getVideoId());
        entity.setChannelId(dto.getChannelId());
        entity.setPublishedDate(LocalDateTime.now());
        entity.setSharedCount(3);
        entity.setViewCount(5);
        videoRepository.save(entity);
        return "Channel Created";
    }
    public Integer update(VideoCreateDTO dto,String videoId) {
        return videoRepository.update(dto.getTitle(), dto.getDescription(), dto.getCategoryId(),dto.getPreviewId(),dto.getVideoId(),videoId);
    }
    public VideoEntity get(String id) {
        Optional<VideoEntity> optional = videoRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Channel not found: " + id);
        }
        return optional.get();
    }

    public String  updateStatus(String videoId) {
        VideoStatus status = videoRepository.getVideoStatus(videoId);
        if (status.equals(VideoStatus.PRIVATE)){
            videoRepository.updateStatus(VideoStatus.PUBLIC, videoId);
            return "Changed to PUBLIC";
        }else {
            videoRepository.updateStatus(VideoStatus.PRIVATE, videoId);
            return "Changed to PRIVATE";
        }
    }
    public Boolean increaseVideoCount(String videoId){
        Integer request = videoRepository.increaseVideoCount(videoId);
        return  request > 0;
    }
    public Page<VideoShortInfoDTO> pagination(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "category_id");
        Pageable pageable = PageRequest.of(page - 1, size,sort);
        Page<VideoEntity> pageObj = videoRepository.findAll(pageable);
        long totalCount = pageObj.getTotalElements();
        List<VideoEntity> entityList = pageObj.getContent();
        List<VideoShortInfoDTO> dtoList = convertToDTO(entityList);
        Page<VideoShortInfoDTO> response = new PageImpl<VideoShortInfoDTO>(dtoList, pageable, totalCount);
        return response;
    }
    public VideoShortInfoMapper searchVideoByTitle(String title) {
        return videoRepository.findVideoShortInfoByTitle(title);
    }

    public List<VideoShortInfoDTO> convertToDTO(List<VideoEntity> entityList) {
        List<VideoShortInfoDTO> dtoList = new LinkedList<>();
        entityList.forEach(entity -> {
            VideoShortInfoDTO dto = new VideoShortInfoDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setPreviewId(entity.getPreviewId());
            dto.setPreview(attachService.getAttachLink(entity.getPreviewId()));
            dto.setChannelId(entity.getChannelId());
            dto.setChannelImage(attachService.getAttachLink(entity.getChannel().getId()));
            dto.setPublishedDate(entity.getPublishedDate());
            dto.setViewCount(entity.getViewCount());
            dto.setChannelName(entity.getChannel().getName());
            dtoList.add(dto);
        });
        return dtoList;
    }


}
