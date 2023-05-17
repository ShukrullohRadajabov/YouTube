package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.category.CategoryDTO;
import com.company.YouTubeProject.dto.category.CategoryResponseDTO;
import com.company.YouTubeProject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/private/adm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private ResponseEntity<CategoryResponseDTO> created(@RequestBody CategoryDTO dto) {
        return ResponseEntity.ok(service.created(dto));
    }

    @PutMapping("/private/update/adm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    private ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }





}
