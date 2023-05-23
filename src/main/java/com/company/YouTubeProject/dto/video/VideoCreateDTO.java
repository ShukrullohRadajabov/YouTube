package com.company.YouTubeProject.dto.video;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoCreateDTO {
    @NotBlank(message = "Where is title !!")
    private String title;
    @NotBlank(message = "Where is description !!")
    private String description;
    @NotBlank(message = "Where is category Id !!")
    private String categoryId;
    @NotBlank(message = "Where is preview Id !!")
    private String previewId;
    @NotBlank(message = "Where is video Id !!")
    private String videoId;
    @NotBlank(message = "Where is channel Id !!")
    private String channelId;

}
