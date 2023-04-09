package com.example.demo.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Document("release_files")
public class ReleaseFiles {
    @Id
    ObjectId id;

    Enum<OSType> osType;

    List<String> files;
}
