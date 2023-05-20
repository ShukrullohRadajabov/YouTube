package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.TagEntity;
import com.company.YouTubeProject.entity.VideoLikeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VideoLikeRepository extends CrudRepository<VideoLikeEntity, Integer>, PagingAndSortingRepository<VideoLikeEntity, Integer> {
}
