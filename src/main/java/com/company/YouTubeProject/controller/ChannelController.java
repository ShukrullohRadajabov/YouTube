package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.channel.ChannelCreateDTO;
import com.company.YouTubeProject.dto.channel.ChannelDTO;
import com.company.YouTubeProject.dto.channel.ChannelUpdateDTO;
import com.company.YouTubeProject.dto.profile.ProfileDTO;
import com.company.YouTubeProject.dto.profile.ProfilePswDTO;
import com.company.YouTubeProject.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")

public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @PostMapping({"/create/", "/create"})
    public ResponseEntity<?> create(@RequestBody ChannelCreateDTO dto) {
        return ResponseEntity.ok(channelService.create(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ChannelUpdateDTO dto) {
        return ResponseEntity.ok(channelService.update(dto));
    }

    @PutMapping(value = "/private/paging")
    public ResponseEntity<Page<ChannelDTO>> paging(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "size", defaultValue = "2") int size) {
        Page<ChannelDTO> response = channelService.pagingtion(page, size);
        return ResponseEntity.ok(response);
    }
    @GetMapping(value = "/getChannelDetail/{id}")
    public ResponseEntity<ChannelDTO> getChannelDetail(@PathVariable("id") String channelId) {
        return ResponseEntity.ok(channelService.getChannelDetail(channelId));
    }
    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable("id") String channelId) {
        return ResponseEntity.ok(channelService.updateStatus(channelId));
    }
    @PostMapping(value = "/userChannelList")
    public ResponseEntity<?> userChannelList() {
        List<ChannelDTO> list = channelService.userChannelList();
        return ResponseEntity.ok(list);
    }

}
