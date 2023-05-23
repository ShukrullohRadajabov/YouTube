package com.company.YouTubeProject.controller;
import com.company.YouTubeProject.service.VideoLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/v1/videolike")
public class VideoLikeController {
    @Autowired
    private VideoLikeService service;

    @PostMapping("/public/createlike/{id}")
    private ResponseEntity<Boolean> created(@PathVariable("id") Integer videoid,@RequestBody Integer profileid) {
        return ResponseEntity.ok(service.create(videoid));
    }

    @PostMapping("/public/dislike/{id}")
    private ResponseEntity<Boolean> dislike(@PathVariable("id") Integer videoid,
                                            @RequestBody Integer profileid) {
        return ResponseEntity.ok(service.dislike(videoid,profileid));
    }

    @PostMapping("/public/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Integer videoid,
                                            @RequestBody Integer profileid) {
        return ResponseEntity.ok(service.delete(videoid,profileid));
    }


}
