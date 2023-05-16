package com.company.YouTubeProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RegistrationDTO {

    private String  name;


    private String surname;


    private String email;


    private String password;




}
