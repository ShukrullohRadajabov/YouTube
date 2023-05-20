package com.company.YouTubeProject.entity;

import com.company.YouTubeProject.enums.VideoLike;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "videolike")
@Entity
public class VideoLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;


    @Column(name = "profile_id")
    private Integer profileID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id",insertable = false, updatable = false)
    private ProfileEntity profile;


    @Column(name = "video_id")
    private Integer videoID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id",insertable = false, updatable = false)
    private ProfileEntity video;

    @Column(name = "created_date")
    private LocalDateTime createdDate=LocalDateTime.now();


    @Column(name = "type")
    private VideoLike type;


}
