package com.company.YouTubeProject.dto.profile;

import com.company.YouTubeProject.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileAdminCreateDTO {
    private String name;
    private String surname;
    private String email;
    private ProfileRole role;
}
