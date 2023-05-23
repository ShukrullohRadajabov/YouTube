package com.company.YouTubeProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "videotag")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VideoTagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "video_id")
    private String video_ID;
    @ManyToOne
    @JoinColumn(name = "video_id", insertable = false, updatable = false)
    private VideoEntity video_id;

    @Column(name = "tag_id")
    private Integer tag_ID;
    @ManyToOne
    @JoinColumn(name = "tag_id", insertable = false, updatable = false)
    private TagEntity tag_id;

    @Column(name = "created_date")
    private LocalDateTime created_date = LocalDateTime.now();

}
