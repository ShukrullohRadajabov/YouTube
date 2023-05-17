package com.company.YouTubeProject.dto.tag;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDTO {
    private String id;
    private String name;
    private LocalDateTime createdDate;
}
