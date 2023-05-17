package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private TagService tagService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@PathVariable("name") String name) {
//        JwtDTO jwtDTO = JwtUtil.getJwtDTO(authorization, ProfileRole.ROLE_ADMIN);
        return ResponseEntity.ok(tagService.create(name));
    }
}
