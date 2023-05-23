package com.company.YouTubeProject.dto.profile;

import jakarta.mail.Message;
import jakarta.mail.event.MailEvent;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfilePswDTO {
    @NotBlank(message = "Where is password !!")
    private String psw;
}
