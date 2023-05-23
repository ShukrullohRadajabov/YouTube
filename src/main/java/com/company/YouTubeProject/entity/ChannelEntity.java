package com.company.YouTubeProject.entity;

import com.company.YouTubeProject.enums.ChannelStatus;
import com.company.YouTubeProject.enums.GeneralStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "channel")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChannelEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "image_id")
    private String imageId;
    @ManyToOne
    @JoinColumn(name = "image_id", insertable = false, updatable = false)
    private AttachEntity image;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ChannelStatus status = ChannelStatus.ACTIVE;
    @Column(name = "banner_id")
    private String bannerId;
    @ManyToOne
    @JoinColumn(name = "banner_id", insertable = false, updatable = false)
    private AttachEntity banner;
    @Column(name = "profile_id")
    private Integer profileId;
    @ManyToOne
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private ProfileEntity profile;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    public ChannelEntity(String id, String name, String imageId, String description, ChannelStatus status, String bannerId, Integer profileId) {
        this.id = id;
        this.name = name;
        this.imageId = imageId;
        this.description = description;
        this.status = status;
        this.bannerId = bannerId;
        this.profileId = profileId;
    }
}
