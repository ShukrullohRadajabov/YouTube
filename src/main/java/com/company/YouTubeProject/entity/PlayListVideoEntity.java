package com.company.YouTubeProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name ="playlistvideo")
@Entity
public class PlayListVideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "playlist_id")
    private String playlistId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id",insertable = false, updatable = false)
    private PlayListEntity playlist;


    @Column(name = "video_id")
    private String video_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id",insertable = false, updatable = false)
    private VideoEntity video;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "order_num")
    private Integer orderNum;


}
