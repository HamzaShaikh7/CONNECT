package com.connect.CONNECT.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
@RestController
@RequestMapping("/public")
public class PublicController
{

    private static final String HEALTH_CHECK_SUCCESS = "OK";


    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck()
    {
        return new ResponseEntity<>(HEALTH_CHECK_SUCCESS, HttpStatus.OK);
    }

}
