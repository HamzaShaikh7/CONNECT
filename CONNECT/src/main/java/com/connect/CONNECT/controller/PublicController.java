package com.connect.CONNECT.controller;


import com.connect.CONNECT.entry.User;
import com.connect.CONNECT.exceptions.WeatherServiceException;
import com.connect.CONNECT.service.UserRepositoryIMPL;
import com.connect.CONNECT.service.UserService;
import com.connect.CONNECT.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/public")
public class PublicController {


    Integer temperature;
    List<String > weather_description;
    private static final String HEALTH_CHECK_SUCCESS = "OK";

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepositoryIMPL userRepositoryIMPL;

    @Autowired
    private WeatherService weatherService;


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


    @GetMapping("/get-email")
    public List<User> getSentiment(){
        return userRepositoryIMPL.getUserForSA();
    }



    @GetMapping("/weather-check/{city}")
    public ResponseEntity<?> weatherCheck(@PathVariable String city){
        try{
            temperature = weatherService.getWeather(city).getCurrent().getTemperature();
            weather_description = weatherService.getWeather(city).getCurrent().getWeatherDescriptions();
            return new ResponseEntity<>(temperature+" "+weather_description,HttpStatus.OK);
        } catch (WeatherServiceException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
