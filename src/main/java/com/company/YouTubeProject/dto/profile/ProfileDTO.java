package com.company.YouTubeProject.dto.profile;

import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import lombok.Data;

@Data
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
