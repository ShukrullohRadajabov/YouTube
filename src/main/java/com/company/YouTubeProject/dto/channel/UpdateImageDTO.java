package com.company.YouTubeProject.dto.channel;

import com.company.YouTubeProject.dto.attach.AttachDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateImageDTO {
    @NotBlank(message = "You must enter Channel id")
    private String id;
    private String imageId;
}
