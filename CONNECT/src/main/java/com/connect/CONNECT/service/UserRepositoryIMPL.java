package com.connect.CONNECT.service;

import com.connect.CONNECT.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryIMPL
{

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<User> getUserForSA(){

        Query query = new Query();
        query.addCriteria(Criteria.where("email_address").regex("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"));
//        query.addCriteria(Criteria.where("sentimentStatus").is(true));
        return mongoTemplate.find(query, User.class);
    }
}
