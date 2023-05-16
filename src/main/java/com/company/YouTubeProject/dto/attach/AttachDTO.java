package com.company.YouTubeProject.dto.attach;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.sqm.produce.function.StandardFunctionReturnTypeResolvers;
@Getter
@Setter
public class AttachDTO {
    private String id;
    private String url;
    private String originalName;

}
