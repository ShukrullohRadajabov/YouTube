package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.categoryDto.CategoryDto;
import com.company.YouTubeProject.dto.categoryDto.CategoryResponseDTO;
import com.company.YouTubeProject.entity.CategoryEntity;
import com.company.YouTubeProject.exeption.AppBadRequestException;
import com.company.YouTubeProject.exeption.ItemAlreadyExistsException;
import com.company.YouTubeProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
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


    public CategoryDto update(Integer id, CategoryDto dto) {
        Optional<CategoryEntity> optional = categoryRepository.findById(id);

        if (optional.isEmpty()) {
            throw new AppBadRequestException("yo'qku");
        }
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setCreatedDate(LocalDateTime.now());
        categoryRepository.save(entity);

        return dto;
    }

    public boolean delete(Integer id) {
        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        if (optional.isEmpty()){
            throw new AppBadRequestException("bu foydalanuvchi yo'q ");
        }
        categoryRepository.delete(optional.get());
        return true;
    }

    public List<CategoryDto> getALl() {
        List<CategoryEntity> entityList = (List<CategoryEntity>) categoryRepository.findAll();
        List<CategoryDto> dtoList = new LinkedList<>();
        entityList.forEach(entity ->
                dtoList.add(toArticleShortInfo(entity)));
        return dtoList;
    }

    private CategoryDto toArticleShortInfo(CategoryEntity entity) {
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
