package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.TagEntity;
import com.company.YouTubeProject.entity.VideoLikeEntity;
import com.company.YouTubeProject.enums.VideoLike;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VideoLikeRepository extends CrudRepository<VideoLikeEntity, Integer>, PagingAndSortingRepository<VideoLikeEntity, Integer> {
    Optional<VideoLikeEntity> findAllByVideoIDAndProfileID(Integer videoid,Integer profileid);


    @Modifying
    @Transactional
    @Query("update VideoLikeEntity  set type =:status where profileID=:profileID and videoID=:videoID")
    int update(@Param("status") VideoLike status,
               @Param("profileID") Integer profileID,
               @Param("videoID") Integer videoID);

    @Modifying
    @Transactional
    @Query("delete from VideoLikeEntity where videoID=:videoID and profileID=:profileID")
    int delete(Integer videoID, Integer profileId);
}
