package com.company.YouTubeProject.dto.video;

import com.company.YouTubeProject.enums.VideoStatus;
import com.company.YouTubeProject.enums.VideoType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoDTO {
    private String id;
    private String previewId;
    private String title;
    private String categoryId;
    private String videoId;
    private LocalDateTime createdDate;
    private LocalDateTime publishedDate;
    private VideoStatus status;
    private VideoType type;
    private Integer viewCount;
    private Integer sharedCount;
    private String description;
    private String channelId;
}
