package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.TagDTO;
import com.company.YouTubeProject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/public/create")
    public ResponseEntity<TagDTO> create(@RequestBody TagDTO dto) {
        return ResponseEntity.ok(tagService.create(dto));
    }

    @PutMapping("/private/update")
    private ResponseEntity<?>update(@RequestBody String name) {
        return ResponseEntity.ok(tagService.update(name));
    }

    @DeleteMapping("/private/delete/{id}")
    private ResponseEntity<?>delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(tagService.delete(id));
    }

    @GetMapping("/public/getAll")
    public ResponseEntity<List<TagDTO>> getAll() {
        List<TagDTO> list = tagService.getAll();
        return ResponseEntity.ok(list);
    }
}
