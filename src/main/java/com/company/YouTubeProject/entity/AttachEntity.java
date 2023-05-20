package com.company.YouTubeProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Table(name = "attach")
@Entity
public class AttachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "original_name")
    private String originalName;
    @Column
    private Long size;
    @Column
    private String type;
    @Column
    private String path;
    @Column
    private String extension;
    @Column(name = "duration")
    private LocalTime duration;

}

