package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.dto.attach.AttachDTO;
import com.company.YouTubeProject.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/attach")
public class AttachController {
    @Autowired
    private AttachService attachService;

    @PostMapping("/public/get")
    public ResponseEntity<byte[]> getById(@RequestParam("id") String id) {
        byte[] byId = attachService.getById(id);
        return ResponseEntity.ok().body(byId);
    }


    @GetMapping("/public/upload")
    public ResponseEntity<AttachDTO> upload(@RequestParam("file") MultipartFile file) {
        AttachDTO res = attachService.upload(file);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/download/{fineName}")
    public ResponseEntity<Resource> download(@PathVariable("fineName") String fileName) {
        Resource file = attachService.download(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}