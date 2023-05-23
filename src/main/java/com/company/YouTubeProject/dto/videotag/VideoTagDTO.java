package com.company.YouTubeProject.dto.videotag;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
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
public class VideoTagDTO {
    @NotBlank(message = "Where is id !!")
    private Integer id;

    @NotBlank(message = "Where is video_id !!")
    private String video_id;

    @NotBlank(message = "Where is tag_id !!")
    private Integer tag_id;

    private LocalDateTime created_date;


}
