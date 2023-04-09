package com.example.demo.model;


import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Document("release")
public class Release {
    @Id
    private ObjectId id;

    private String name;

    private String version;

    private Enum<OSType> osType;

    private String file;

    private boolean is_approved;

    private List<ReleaseFile> releaseFilesList;

    @Indexed(unique = true)
    private String slug;
}
