package com.example.demo.model;

import java.io.Serializable;

// Non-MongoDB implementation
public class Customer implements Serializable {

    private String name;
    private String age;

    public Customer(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
