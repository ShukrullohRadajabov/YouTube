package com.company.YouTubeProject.dto.channel;

import com.company.YouTubeProject.dto.attach.AttachDTO;
import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.enums.ChannelStatus;
import com.company.YouTubeProject.enums.GeneralStatus;
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
public class ChannelDTO {
    private String id;
    private String name;
    private String imageId;
    private String description;
    private ChannelStatus status ;
    private String bannerId;
    private Integer profileId;
}
