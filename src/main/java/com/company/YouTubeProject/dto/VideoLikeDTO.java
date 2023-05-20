package com.company.YouTubeProject.dto;

import com.company.YouTubeProject.enums.VideoLike;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VideoLikeDTO {
    private Integer id;
    private Integer profile_id;
    private Integer video_id;
    private LocalDateTime created_date;
    private VideoLike videoLike;



}
