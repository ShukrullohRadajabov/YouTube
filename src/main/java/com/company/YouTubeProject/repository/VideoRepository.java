package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.dto.video.VideoShortInfoDTO;
import com.company.YouTubeProject.entity.VideoEntity;
import com.company.YouTubeProject.enums.VideoStatus;
import com.company.YouTubeProject.mapper.VideoShortInfoMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VideoRepository extends CrudRepository<VideoEntity, String>, PagingAndSortingRepository<VideoEntity, String> {
    @Query(value = "SELECT v.status FROM video AS v  where  v.id =:id ", nativeQuery = true)
    VideoStatus getVideoStatus(@Param("id") String id);

    Optional findByTitle(String title);

    @Transactional
    @Modifying
    @Query("update VideoEntity set title =:title,description =:description,categoryId = :categoryId,previewId = :previewId,videoId = :videoId where id = :id")
    Integer update(@Param("title") String title, @Param("description") String description, @Param("categoryId") String categoryId,
                   @Param("previewId") String previewId, @Param("videoId") String videoId, @Param("id") String id);

    @Transactional
    @Modifying
    @Query("update VideoEntity set status = :status where id = :id")
    void updateStatus(@Param("status") VideoStatus status, @Param("id") String id);

    @Transactional
    @Modifying
    @Query("UPDATE VideoEntity as v SET v.viewCount = v.viewCount + 1 WHERE v.id = :id")
    Integer increaseVideoCount(@Param("id") String id);

    @Query("select new com.company.YouTubeProject.mapper.VideoShortInfoMapper(v.id,v.title,v.previewId,v.publishedDate,v.channelId,v.channel.name,v.channel.image.id,v.viewCount) from VideoEntity as v where v.title = :title")
    VideoShortInfoMapper findVideoShortInfoByTitle(@Param("title") String title);



}
