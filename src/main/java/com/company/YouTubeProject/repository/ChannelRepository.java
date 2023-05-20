package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.ChannelEntity;
import com.company.YouTubeProject.enums.ChannelStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChannelRepository extends CrudRepository<ChannelEntity, String>, PagingAndSortingRepository<ChannelEntity, String > {

    @Transactional
    @Modifying
    @Query("update ChannelEntity set name =:name,description =:description  where id = :id")
    Integer update(@Param("name") String name,@Param("description") String description, @Param("id") String id);
    @Transactional
    @Modifying
    @Query("update ChannelEntity set imageId = :imageId where id = :id")
    Integer updateImage(@Param("imageId") String imageId, @Param("id") String id);

    @Transactional
    @Modifying
    @Query("update ChannelEntity set bannerId = :bannerId where id = :id")
    Integer updateBanner(@Param("bannerId") String bannerId, @Param("id") String id);

    @Query("SELECT new ChannelEntity(ch.id,ch.name,ch.imageId,ch.description,ch.status,ch.bannerId,ch.profileId) FROM ChannelEntity as ch where ch.id = :id")
    ChannelEntity getChannelDetail(@Param("id") String id);

    @Transactional
    @Modifying
    @Query("update ChannelEntity set status = :status where id = :id")
    void updateStatus(@Param("status") ChannelStatus status, @Param("id") String id);

    @Query("SELECT new ChannelEntity(ch.id,ch.name,ch.imageId,ch.description,ch.status,ch.bannerId,ch.profileId) FROM ChannelEntity as ch where ch.profileId = :profileId")
    List<ChannelEntity> userChannelList(@Param("profileId") Integer profileId);


}
