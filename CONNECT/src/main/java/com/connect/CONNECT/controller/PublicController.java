package com.connect.CONNECT.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/public")
public class PublicController {

    private static final String HEALTH_CHECK_SUCCESS = "OK";

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>(HEALTH_CHECK_SUCCESS, HttpStatus.OK);
    }
}
