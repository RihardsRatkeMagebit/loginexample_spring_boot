package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class User {

    @Autowired
    UserService userService;

    @PostMapping("add")
    public boolean add(
            @RequestParam(name = "username", defaultValue = "bob") String username,
            @RequestParam(name = "password", required = true) String password
    ) {
        com.example.demo.model.User user = new com.example.demo.model.User();
        user.setPassword(password);
        user.setUsername(username);
        userService.addUser(user);
        return true;
    }

    @GetMapping("list")
    public List<com.example.demo.model.User> list() {
        return userService.listUser(10);
    }
}
