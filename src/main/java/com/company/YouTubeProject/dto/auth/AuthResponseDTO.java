package com.company.YouTubeProject.dto.auth;

import com.company.YouTubeProject.enums.ProfileRole;
import lombok.Data;

@Data
public class AuthResponseDTO {
    private String name;
    private String surname;
    private ProfileRole role;
    private String jwt;
}
