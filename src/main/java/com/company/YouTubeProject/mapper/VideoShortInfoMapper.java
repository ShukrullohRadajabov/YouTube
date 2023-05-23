package com.company.YouTubeProject.mapper;

import com.company.YouTubeProject.dto.attach.AttachDTO;
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
public class VideoShortInfoMapper {
    private String id;
    private String title;
    private String previewId;
    private LocalDateTime publishedDate;
    private String channelId;
    private String channelName;
    private String channelImageId;
    private Integer viewCount;

}

