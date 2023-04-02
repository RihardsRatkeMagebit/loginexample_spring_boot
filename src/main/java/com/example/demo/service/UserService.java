package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User getUserByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where(User.FIELD_USERNAME).is(name));

        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public List<User> getList() {
        return this.userRepository.findAll();
    }
}
