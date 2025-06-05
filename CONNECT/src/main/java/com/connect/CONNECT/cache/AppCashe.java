package com.connect.CONNECT.cache;


import com.connect.CONNECT.entry.ConfigApiEntry;
import com.connect.CONNECT.repository.ConfigAPIRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppCashe
{

    public static String APP_CASHE = null;


    @Autowired
    private ConfigAPIRepository configAPIRepository;


    @PostConstruct
    public void init(){
        List<ConfigApiEntry> configApiEntries = configAPIRepository.findAll();
        APP_CASHE = configApiEntries.getFirst().getAPI_KEY();
    }
}
