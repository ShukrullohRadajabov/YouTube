package com.company.YouTubeProject.entity;

import com.company.YouTubeProject.enums.VideoStatus;
import com.company.YouTubeProject.enums.VideoType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vidoe")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne
    @JoinColumn(name = "preview_attach_id", insertable = false, updatable = false)
    private AttachEntity previewAttach;
    @Column(name = "preview_attach_id")
    private Integer previewAttachId;
    @Column
    private String title;
    @Column(name = "category_id")
    private Integer categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;
    @Column(name = "attach_id")
    private Integer attachId;
    @ManyToOne
    @JoinColumn(name = "attach_id", insertable = false, updatable = false)
    private AttachEntity attach;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "published_date")
    private LocalDateTime publishedDate;
    @Enumerated(EnumType.STRING)
    @Column
    private VideoStatus status;
    @Enumerated(EnumType.STRING)
    @Column
    private VideoType type;
    @Column(name = "view_count")
    private Integer viewCount;
    @Column(name = "shared_count")
    private Integer sharedCount;
    @Column
    private Integer description;
    private String channelId;
    @Column(name = "like_count")
    private Integer likeCount;
    @Column(name = "dislike_count")
    private Integer dislikeCount;
}