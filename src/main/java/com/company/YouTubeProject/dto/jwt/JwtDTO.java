package com.company.YouTubeProject.dto.jwt;

import com.company.YouTubeProject.enums.ProfileRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtDTO {
    private String email;
    private ProfileRole role;
}
