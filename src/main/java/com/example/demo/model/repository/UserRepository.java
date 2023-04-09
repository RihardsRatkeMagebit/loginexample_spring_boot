package com.example.demo.model.repository;

import java.util.Optional;

import com.example.demo.model.Release;
import org.bson.types.ObjectId;
import com.example.demo.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUsername(String username);

    @Query(value = "{slug: ?0}", fields = "{ 'slug': 0}")
    public Optional<User> findBySlug(String slug);
}
