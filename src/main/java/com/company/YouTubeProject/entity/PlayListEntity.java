package com.company.YouTubeProject.entity;


import com.company.YouTubeProject.enums.VideoStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name ="playlist")
@Entity
public class PlayListEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        @Column(name = "channel_id")
        private String channelId;
        @Column(name = "description")
        private String description;
        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        private VideoStatus status;
        @Column(name = "orderNumber")
        private Integer orderNumber;
        @Column(name = "visible")
        private Boolean visible=true;

}
