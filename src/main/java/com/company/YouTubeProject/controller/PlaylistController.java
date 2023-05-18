package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.playlist.PlaylistDTO;
import com.company.YouTubeProject.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/create")
    private ResponseEntity<PlaylistDTO> create(@RequestBody PlaylistDTO dto) {
        return ResponseEntity.ok(playlistService.create(dto));
    }
    @PutMapping("/update")
    private ResponseEntity<PlaylistDTO> update(@RequestBody PlaylistDTO dto) {
        return ResponseEntity.ok(playlistService.update(dto));
    }
    @PutMapping("/update-status")
    private ResponseEntity<?> updateStatus(@RequestParam("id") String id) {
        return ResponseEntity.ok(playlistService.updateStatus(id));
    }
    @PutMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam("id") String id) {
        return ResponseEntity.ok(playlistService.delete(id));
    }
    @GetMapping(value = "/paging")
    public ResponseEntity<Page<PlaylistDTO>> paging(@RequestParam(value = "page", defaultValue = "1") int page,
                                                            @RequestParam(value = "size", defaultValue = "3") int size) {
        return ResponseEntity.ok(playlistService.getPlaylistPaging(page,size));
    }
}
