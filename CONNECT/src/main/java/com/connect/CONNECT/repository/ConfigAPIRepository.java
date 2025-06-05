package com.connect.CONNECT.repository;

import com.connect.CONNECT.entry.ConfigApiEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ConfigAPIRepository extends MongoRepository<ConfigApiEntry, ObjectId> {

}
