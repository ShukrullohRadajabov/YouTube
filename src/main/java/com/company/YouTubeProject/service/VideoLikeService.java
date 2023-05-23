package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.VideoLikeDTO;
import com.company.YouTubeProject.entity.VideoLikeEntity;
import com.company.YouTubeProject.enums.VideoLike;
import com.company.YouTubeProject.repository.VideoLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoLikeService {

    @Autowired
    private VideoLikeRepository repository;
    public Boolean create(Integer videoid,Integer profileid) {
        makeEmotion(videoid, profileid, VideoLike.LIKE);
        return true;
    }

    public VideoLikeDTO remove(VideoLikeDTO dto) {
        VideoLikeEntity entity=new VideoLikeEntity();

        return dto;
    }

    private void makeEmotion(Integer videoid,Integer profileid, VideoLike status) {
        Optional<VideoLikeEntity> optional = repository
                .findAllByVideoIDAndProfileID(videoid,profileid);
        if (optional.isEmpty()) {
            VideoLikeEntity entity = new VideoLikeEntity();
            entity.setVideoID(videoid);
            entity.setProfileID(profileid);
            entity.setType(status);
            repository.save(entity);
        } else {
            repository.update( status,profileid, videoid);
        }
    }

    public Boolean dislike(Integer videoid, Integer profileid) {
        makeEmotion(videoid, profileid, VideoLike.DISLIKE);
        return true;
    }

    public Boolean delete(Integer videoid, Integer profileid) {
        repository.delete(videoid, profileid);
        return true;
    }
}
