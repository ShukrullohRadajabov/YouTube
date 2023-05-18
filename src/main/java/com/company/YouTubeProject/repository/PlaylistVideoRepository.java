package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.PlayListVideoEntity;
import com.company.YouTubeProject.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlaylistVideoRepository extends CrudRepository<PlayListVideoEntity, Integer>, PagingAndSortingRepository<PlayListVideoEntity, Integer> {

}
