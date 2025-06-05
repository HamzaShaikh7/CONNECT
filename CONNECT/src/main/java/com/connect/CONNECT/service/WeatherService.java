package com.connect.CONNECT.service;


import com.connect.CONNECT.cache.AppCashe;
import com.connect.CONNECT.response.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class WeatherService
{

//    This method use when you store API in application.yml file.
//    @Value("${weather.api.key}")
//    private String API_KEY;


    private static final String URL = "http://api.weatherstack.com/current?access_key=<api_key>&query=<city>";


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private RedisService redisService;


    public WeatherResponse getWeather(String city){

//          This method use when you store API in application.yml file.
//        String FINAL_API = API.replace("<api_key>",API_KEY).replace("<city>",city);


        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse != null){
            return weatherResponse;
        }
        else {
            String FINAL_API = URL.replace("<api_key>", AppCashe.APP_CASHE).replace("<city>",city);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(FINAL_API, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body!=null){
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;

        }
    }
}
