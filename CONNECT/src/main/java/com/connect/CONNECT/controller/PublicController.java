package com.connect.CONNECT.controller;


import com.connect.CONNECT.entry.User;
import com.connect.CONNECT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public")
public class PublicController {

    private static final String HEALTH_CHECK_SUCCESS = "OK";

    @Autowired
    private UserService userService;


    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>(HEALTH_CHECK_SUCCESS, HttpStatus.OK);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> createNewAccount(@RequestBody User user){
        try {
            return new ResponseEntity<>(userService.createNewAccount(user),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
