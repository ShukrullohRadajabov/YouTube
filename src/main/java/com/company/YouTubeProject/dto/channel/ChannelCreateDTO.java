package com.company.YouTubeProject.dto.channel;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChannelCreateDTO {
    @NotBlank(message = "Name must have some value")
    private String name;
    private String imageId;
    @NotBlank(message = "Description must have some value")
    private String description;
    private String bannerId;
}
