package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.tag.TagDTO;
import com.company.YouTubeProject.dto.videotag.VideoTagDTO;
import com.company.YouTubeProject.service.VideoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video")
public class VideoTagController {
    @Autowired
    private VideoTagService videoTagService;
    @PostMapping("/private/add/{id}")
    public ResponseEntity<VideoTagDTO> create(@PathVariable("id") String videoid,
                                              @RequestBody VideoTagDTO dto) {
        return ResponseEntity.ok(videoTagService.add(videoid,dto));
    }
    @DeleteMapping("/private/delete/{id}")
    private ResponseEntity<?>delete(@PathVariable("id") String videoid,
                                    @RequestBody VideoTagDTO dto) {
        return ResponseEntity.ok(videoTagService.delete(videoid,dto));
    }


}
