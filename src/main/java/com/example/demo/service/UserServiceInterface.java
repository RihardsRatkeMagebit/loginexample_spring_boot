package com.example.demo.service;

import com.example.demo.model.User;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// username : role
// mohamed admin

public interface UserServiceInterface {

    public Optional<User> getUserById(ObjectId id);

    public User addUser(User user);

    public List<User> listUser(int limit);

    public List<User> sortUsers(boolean desc);

    public List<User> searchForUsers(String filter);

    public void addListOfUsers(List<User> listofUser);
}
