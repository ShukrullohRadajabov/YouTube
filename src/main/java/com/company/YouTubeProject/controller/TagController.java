package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private TagService tagService;
    @PostMapping("/private/create")
    public ResponseEntity<?> create(@RequestParam("name") String name) {
        return ResponseEntity.ok(tagService.create(name));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("name") String name) {
        return ResponseEntity.ok(tagService.delete(name));
    }
//    @PutMapping("/update")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public ResponseEntity<?> update(@RequestParam("name") String name) {
//        return ResponseEntity.ok(tagService.update(name));
//    }
    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(tagService.getList());
    }
}
