package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.VideoLikeDTO;
import com.company.YouTubeProject.dto.category.CategoryDTO;
import com.company.YouTubeProject.dto.category.CategoryResponseDTO;
import com.company.YouTubeProject.service.VideoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/videolike")
public class VideoLikeController {
    @Autowired
    private VideoLikeService service;

    @PostMapping("/public/createlike")
    private ResponseEntity<VideoLikeDTO> created(@RequestBody VideoLikeDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PostMapping("/public/remove")
    private ResponseEntity<VideoLikeDTO> remove(@RequestBody VideoLikeDTO dto) {
        return ResponseEntity.ok(service.remove(dto));
    }

}
