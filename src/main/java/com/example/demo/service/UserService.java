package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }


    // User 1 bob option123
    // User 2 bob option111
    @Override
    public User addUser(User user) {
        List<User> users = userRepository.findAll();
        for (User userDB : users) {
            if (userDB.getUsername() == user.getUsername()) {
                throw new RuntimeException("Users already exist");
            }
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> listUser(int limit) {
        List<User> users = userRepository.findAll();
        List<User> result = users.subList(0,Math.min(users.size(),limit));
        return result;
    }

    @Override
    public List<User> sortUsers(boolean desc) {
        List<User> users = userRepository.findAll();
        Collections.sort(users);
        if (desc){
            Collections.sort(users,Collections.reverseOrder());
        }
        return users;
    }

    @Override
    public List<User> searchForUsers(String filter) {
        List<User> users = userRepository.findAll();
        List<User> result = new ArrayList<User>();
        for (User user: users){
            if (user.getUsername().contains(filter)){
                result.add(user);
            }
        }

        return result;
    }

    @Override
    public void addListOfUsers(List<User> listofUser) {
        for (User user: listofUser){
            this.addUser(user);
        }
    }
}
