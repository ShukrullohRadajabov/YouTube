package com.company.YouTubeProject.dto.categoryDto;

import com.company.YouTubeProject.entity.CategoryEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponseDTO {
    Integer id;
    String name;
    LocalDateTime createdDate;


    public static CategoryResponseDTO toDTO(CategoryEntity entity) {
        return CategoryResponseDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
