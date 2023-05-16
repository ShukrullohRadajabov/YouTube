package com.company.YouTubeProject.dto;


import com.company.YouTubeProject.enums.ProfileRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {


    private String name;

    private String surname;

    private ProfileRole role;

    private String jwt;


}
