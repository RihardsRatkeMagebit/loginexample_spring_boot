package com.example.demo.service;

import com.example.demo.model.FilterClass;
import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }


    // User 1 bob option123
    // User 2 bob option111
    @Override
    public User addUser(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(user));
        User dbUser = mongoTemplate.findOne(query,User.class);

        if (dbUser != null){
            throw new RuntimeException("User already exist");
        }

        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public List<User> listUser(int limit) {
        List<User> users = userRepository.findAll();
        List<User> result = users.subList(0, Math.min(users.size(), limit));
        return result;
    }

    @Override
    public List<User> sortUsers(boolean desc) {
        List<User> users = userRepository.findAll();
        Collections.sort(users);
        if (desc) {
            Collections.sort(users, Collections.reverseOrder());
        }
        return users;
    }

    @Override
    public List<User> searchForUsers(String filter) {
        List<User> users = userRepository.findAll();
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(filter));
        List<User> user = mongoTemplate.find(query, User.class);

        return user;
    }


    public List<User> search(List<FilterClass> filters){
        Query query = new Query();

        filters.forEach(filterClass -> {
            Criteria criteria = Criteria.where(filterClass.field);
            if (filterClass.reqType.equals(FilterClass.type.EQ)) {
                criteria.is(filterClass.value);
            } else if (filterClass.reqType.equals(FilterClass.type.GT)) {
                criteria.gt(filterClass.value);
            } else {
                criteria.is(filterClass.value);
            }
            query.addCriteria(criteria);
        });
        return mongoTemplate.find(query,User.class);
    }

    @Override
    public void addListOfUsers(List<User> listofUser) {
        for (User user : listofUser) {
            this.addUser(user);
        }
    }
}
