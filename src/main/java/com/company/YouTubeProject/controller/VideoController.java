package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.video.VideoCreateDTO;
import com.company.YouTubeProject.dto.video.VideoShortInfoDTO;
import com.company.YouTubeProject.mapper.VideoShortInfoMapper;
import com.company.YouTubeProject.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping({"/create/", "/create"})
    public ResponseEntity<?> create(@RequestBody VideoCreateDTO dto) {
        return ResponseEntity.ok(videoService.create(dto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody VideoCreateDTO dto,
                                    @PathVariable("id") String videoId) {
        return ResponseEntity.ok(videoService.update(dto,videoId));
    }
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable("id") String videoId) {
        return ResponseEntity.ok(videoService.updateStatus(videoId));
    }
    @PutMapping(value = "/increaseVideoCount/{id}")
    public ResponseEntity<?> increaseVideoCount(@PathVariable("id") String videoId) {
        return ResponseEntity.ok(videoService.increaseVideoCount(videoId));
    }
    @PutMapping(value = "/paging")
    public ResponseEntity<Page<VideoShortInfoDTO>> paging(@RequestParam(value = "page", defaultValue = "1") int page,
                                                          @RequestParam(value = "size", defaultValue = "2") int size) {
        Page<VideoShortInfoDTO> response = videoService.pagination(page, size);
        return ResponseEntity.ok(response);
    }
    @GetMapping(value = "/SearchVideoByTitle/{title}")
    public ResponseEntity<VideoShortInfoMapper> searchVideoByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(videoService.searchVideoByTitle(title));
    }


}
