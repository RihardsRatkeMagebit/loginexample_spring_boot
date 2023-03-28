package com.example.demo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("user")
public class User implements Comparable<User> {

    @Id
    ObjectId id;

    @Max(20)
    @Min(2)
    String username;

    String password;

    @Override
    public int compareTo(User user) {
        return username.compareTo(user.username);
    }
}
