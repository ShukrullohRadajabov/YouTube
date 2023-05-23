package com.company.YouTubeProject.entity;

import com.company.YouTubeProject.enums.VideoStatus;
import com.company.YouTubeProject.enums.VideoType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "video")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VideoEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column(name = "preview_id")
    private String previewId;
    @ManyToOne
    @JoinColumn(name = "preview_id", insertable = false, updatable = false)
    private AttachEntity preview;
    @Column(name = "title", columnDefinition = "TEXT")
    private String title;
    @Column(name = "category_id")
    private String categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;
    @Column(name = "video_id")
    private String videoId;
    @ManyToOne
    @JoinColumn(name = "video_id", insertable = false, updatable = false)
    private AttachEntity video;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "published_date")
    private LocalDateTime publishedDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VideoStatus status = VideoStatus.PUBLIC;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private VideoType type = VideoType.LONGVIDEO;
    @Column(name = "view_count")
    private Integer viewCount;
    @Column(name = "shared_count")
    private Integer sharedCount;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "channel_id")
    private String channelId;
    @ManyToOne
    @JoinColumn(name = "channel_id", insertable = false, updatable = false)
    private ChannelEntity channel;


}
