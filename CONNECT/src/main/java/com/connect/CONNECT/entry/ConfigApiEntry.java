package com.connect.CONNECT.entry;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "config_api")
@Data
public class ConfigApiEntry
{
    @Id
    private ObjectId id;

    private String API_KEY;
}
