package com.company.YouTubeProject.dto.tag;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Data
public class TagDTO {
private  Integer id;
private  String name;
private LocalDateTime created_date=LocalDateTime.now();


}
