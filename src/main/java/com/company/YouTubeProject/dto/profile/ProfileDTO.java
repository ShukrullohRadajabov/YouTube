package com.company.YouTubeProject.dto.profile;

import com.company.YouTubeProject.dto.attach.AttachDTO;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private Integer id;
    @NotBlank(message = "Where is name !!")
    private String name;
    @NotBlank(message = "Where is surname !!")
    private String surname;
    @NotBlank(message = "Where is email !!")
    private String email;
    @NotBlank(message = "Where is password !!")
    private String password;
    private AttachDTO photo;
    private ProfileRole role;
    private GeneralStatus status;
}
