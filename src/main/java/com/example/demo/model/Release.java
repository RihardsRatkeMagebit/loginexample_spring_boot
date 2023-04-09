package com.example.demo.model;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Document("release")
public class Release {
    private ObjectId id;

    private String name;

    private String version;

    private Enum<OSType> osType;

    private String file;

    private boolean is_approved;

    private List<ReleaseFiles> releaseFilesList;

    private String slug;
}
