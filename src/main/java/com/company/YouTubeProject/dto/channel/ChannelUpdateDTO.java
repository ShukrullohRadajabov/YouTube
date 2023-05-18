package com.company.YouTubeProject.dto.channel;

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
public class ChannelUpdateDTO {
    @NotBlank(message = "You must enter Channel id")
    private String id;
    @NotBlank(message = "Name must have some value")
    private String name;
    @NotBlank(message = "Description must have some value")
    private String description;
}
