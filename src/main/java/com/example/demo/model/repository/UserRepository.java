package com.example.demo.model.repository;

import java.util.Optional;
import org.bson.types.ObjectId;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUsername(String username);
}
