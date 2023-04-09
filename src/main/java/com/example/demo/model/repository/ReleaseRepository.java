package com.example.demo.model.repository;

import com.example.demo.model.Release;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReleaseRepository extends MongoRepository<Release, ObjectId> {

    @Query(value = "{slug: ?0}", fields = "{ 'slug': 0}")
    public Optional<Release> findBySlug(String slug);
}
