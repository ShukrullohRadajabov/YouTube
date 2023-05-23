package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.entity.VideoTagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface VideoTagRepository extends CrudRepository<VideoTagEntity, String>, PagingAndSortingRepository<VideoTagEntity, String> {
    Optional<VideoTagEntity> findAllByVideo_ID(String videoid);
}
