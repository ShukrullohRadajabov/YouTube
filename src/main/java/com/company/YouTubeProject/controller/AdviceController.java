package com.company.YouTubeProject.controller;

import com.company.YouTubeProject.exeption.AppBadRequestException;
import com.company.YouTubeProject.exeption.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;

public class AdviceController {
    @ExceptionHandler({AppBadRequestException.class,
            ItemNotFoundException.class,
            MethodNotAllowedException.class})
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleNotValidException(RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
