package com.company.YouTubeProject.dto.playlistvideo;

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
public class PlayListVideoDTO {

    private String id;
    private String PlayListId;
    private String VideoId;
    private LocalDateTime CreatedDate;
    private Integer orderNum;

}
