package com.example.demo.model.repository;

import com.example.demo.model.AuthenticationLogger;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthenticationLoggerRepository extends MongoRepository<AuthenticationLogger, ObjectId> {

}
