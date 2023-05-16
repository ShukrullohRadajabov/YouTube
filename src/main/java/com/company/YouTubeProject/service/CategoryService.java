package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.categoryDto.CategoryDto;
import com.company.YouTubeProject.dto.categoryDto.CategoryResponseDTO;
import com.company.YouTubeProject.entity.CategoryEntity;
import com.company.YouTubeProject.exeption.ItemAlreadyExistsException;
import com.company.YouTubeProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDTO created(CategoryDto dto) {
        Optional<CategoryEntity> optional = categoryRepository.findByName(dto.getName());

        if (optional.isPresent()) {
            throw new ItemAlreadyExistsException("Category already exists!");
        }

        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setCreatedDate(LocalDateTime.now());
        categoryRepository.save(entity);
        return CategoryResponseDTO.toDTO(entity);
    }


    public CategoryResponseDTO toDTO(CategoryEntity entity) {
        CategoryResponseDTO dto = new CategoryResponseDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreatedDate(entity.getCreatedDate());

        return dto;
    }


}
