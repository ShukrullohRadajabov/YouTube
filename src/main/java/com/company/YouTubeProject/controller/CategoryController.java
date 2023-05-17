package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.categoryDto.CategoryDto;
import com.company.YouTubeProject.dto.categoryDto.CategoryResponseDTO;
import com.company.YouTubeProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/private/adm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private ResponseEntity<CategoryResponseDTO> created(@RequestBody CategoryDto dto) {
        return ResponseEntity.ok(service.created(dto));
    }

    @PutMapping("/private/update/adm/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private ResponseEntity<CategoryDto> update(@PathVariable("id") Integer id,@RequestBody CategoryDto dto) {
        return ResponseEntity.ok(service.update(id,dto));
    }


    @DeleteMapping("/private/delete/adm/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/public/list")
    private ResponseEntity<List<CategoryDto>> list() {
        return ResponseEntity.ok(service.getALl());
    }


}
