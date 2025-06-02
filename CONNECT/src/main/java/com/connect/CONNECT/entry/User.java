package com.connect.CONNECT.entry;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User
{
    @Id
    private ObjectId id;

    @NonNull
    private String username;

    private String email_address;

    @NonNull
    private String password;

    private String role;
    private LocalDate localDate;

    @DBRef
    private List<ProfileEntry> profileEntry = new ArrayList<>();

}