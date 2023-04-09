package com.example.demo.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Document("project")
public class Project {
    @Id
    private ObjectId id;

    private String name;

    private String description;

    private List<User> users;

    private String version;

    private List<Release> releases;

    @Indexed(unique = true)
    private String slug;
}
