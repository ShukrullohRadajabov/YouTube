package com.company.YouTubeProject.dto.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileUpdateDTO {
    @NotBlank(message = "Where is name !!")
    private String name;
    @NotBlank(message = "Where is surname !!")
    private String surname;
}
