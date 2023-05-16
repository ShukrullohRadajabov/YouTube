package com.company.YouTubeProject.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {

    @Email(regexp = "email is empty")
    private  String email;
    @NotNull(message = "password is empty")
    private String password;




}
