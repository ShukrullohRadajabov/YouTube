package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.playlistvideo.PlayListVideoDTO;;
import com.company.YouTubeProject.service.PlayListVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/playlistvideo")
public class PlayLitsVideoController {
    @Autowired
    private PlayListVideoService videoService;

    @PostMapping("/private/create")
    public ResponseEntity<PlayListVideoDTO> create(@RequestBody PlayListVideoDTO dto) {
        return ResponseEntity.ok(videoService.create(dto));
    }


}
