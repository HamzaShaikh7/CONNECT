package com.connect.CONNECT.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisService
{

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public <T> T get(String key, Class<T> entityclass){
        try {
            Object o = redisTemplate.opsForValue().get(key);
            ObjectMapper mapper = new ObjectMapper();
            assert o != null;
            return mapper.readValue(o.toString(),entityclass);
        } catch (Exception e) {
            log.error("Exception",e);
            return null;
        }
    }


    public void set(String key, Object o, Long ttl){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue = mapper.writeValueAsString(o);
            redisTemplate.opsForValue().set(key, jsonValue, ttl, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Exception",e);
        }
    }

}
