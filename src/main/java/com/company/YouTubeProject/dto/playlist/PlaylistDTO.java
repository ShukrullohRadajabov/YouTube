package com.company.YouTubeProject.dto.playlist;

import com.company.YouTubeProject.enums.PlaylistStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaylistDTO {
    private String id;
    private String channelId;
    private String description;
    private PlaylistStatus status;
    private Integer orderNumber;
}
