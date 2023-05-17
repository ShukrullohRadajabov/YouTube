package com.company.YouTubeProject.dto.profile;

import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    //private Attach photo;
    private ProfileRole role;
    private GeneralStatus status;
}
