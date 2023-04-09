package com.example.demo.model.repository;

import com.example.demo.model.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, ObjectId> {
    @Query(value = "{slug: ?0}", fields = "{ 'slug': 0}")
    public Optional<Project> findBySlug(String slug);
}
