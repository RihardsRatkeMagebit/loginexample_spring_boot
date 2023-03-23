package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "index")
public class Index {

    @GetMapping("home")
    public String homePage() {
        return "Welcome to home";
    }

    @GetMapping("blog")
    public String blog(@RequestParam(name = "id", required = false) String id) {
        return "your tried to visit blog #" + id;
    }

    @RequestMapping(value = "view/{id}")
    public String view(@PathVariable String id) {
        return "your tried to view#" + id;
    }
}
